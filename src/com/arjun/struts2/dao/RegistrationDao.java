package com.arjun.struts2.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.arjun.appconstant.ApplicationConstant;
import com.arjun.appconstant.Utility;
import com.arjun.struts2.dto.RegistrationDTO;

public class RegistrationDao {
	public int save(RegistrationDTO registrationDTO ) throws SQLException, ClassNotFoundException, IOException{
		int saveStatus = 0;
		Connection con = null;
		PreparedStatement pstmt;
		con = ConnactionManager.getConnection();
		ResultSet resultSet = null;
		resultSet=checkRecord( registrationDTO.getEmailId() ,  con);
		if(!resultSet.next()){
			int maxID = 0;
			Statement s2 = con.createStatement();
			s2.execute("SELECT MAX(USER_ID)+1 FROM struts.USER_INFO");    
			ResultSet rs2 = s2.getResultSet(); 
			while ( rs2.next() ){
			  maxID = rs2.getInt(1);
			}
			pstmt = con.prepareStatement("INSERT INTO struts.USER_INFO VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, maxID);
			pstmt.setString(2, registrationDTO.getFirstName());
			pstmt.setString(3, registrationDTO.getLastName());
			pstmt.setString(4, registrationDTO.getEmailId());
			pstmt.setString(5, registrationDTO.getInvitationCode());
			pstmt.setTimestamp(6,ApplicationConstant.getCurrentTimeStamp());
			pstmt.setTimestamp(7,null);
			pstmt.setTimestamp(8,null);
			pstmt.setString(9, Utility.getMD5(registrationDTO.getPassword()));
			saveStatus = pstmt.executeUpdate();	
			pstmt.close();
		}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return saveStatus;	
	}
	public static ResultSet checkRecord(final String userEmail , Connection con) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = con.prepareStatement("SELECT USER_EMAIL , USER_PASSWORD FROM struts.USER_INFO WHERE USER_INFO.USER_EMAIL=? ");
		pstmt.setString(1, userEmail);
		rs = pstmt.executeQuery();
		return rs;
		
	}

}
