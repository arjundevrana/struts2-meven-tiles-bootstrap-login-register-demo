package com.arjun.struts2.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arjun.appconstant.Utility;
import com.arjun.struts2.dto.LoginDTO;

public class LoginDao {
	public boolean getUserCredentials(LoginDTO loginDTO) throws ClassNotFoundException, SQLException, IOException , NullPointerException {
		boolean loginStatus = false;
		Connection con = null;
		String userPassword = null;
		String userName = null;
		con = ConnactionManager.getConnection();
		ResultSet resultSet = null;
		resultSet = RegistrationDao.checkRecord(loginDTO.getUserName(), con);
		if (resultSet.next()) {
			userName = resultSet.getString("USER_EMAIL");
			userPassword = resultSet.getString("USER_PASSWORD");
		}
		if (userPassword.equals(Utility.getMD5(loginDTO.getPassword())) && userName.equals(loginDTO.getUserName())) {
			loginStatus = true;
		}
		return loginStatus;
	}
}
