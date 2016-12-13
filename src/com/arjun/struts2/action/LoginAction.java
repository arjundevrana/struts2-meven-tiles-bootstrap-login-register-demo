package com.arjun.struts2.action;

import java.io.IOException;
import java.sql.SQLException;

import com.arjun.struts2.dao.LoginDao;
import com.arjun.struts2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author NIC
 * @version 1.0 
 * @see User authentication.
 */
public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3147536955855052398L;
	private LoginDTO loginDTO;
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}
	public String execute(){
		return SUCCESS;
		
	}
	
	public String userValidate(){
		LoginDao loginDao = new LoginDao();
		try {
			if(loginDao.getUserCredentials(loginDTO)){
				return SUCCESS;	
			}
		} catch (ClassNotFoundException | SQLException | NullPointerException |IOException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

}
