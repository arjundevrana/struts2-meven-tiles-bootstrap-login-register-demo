package com.arjun.struts2.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.arjun.struts2.dao.RegistrationDao;
import com.arjun.struts2.dto.RegistrationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RegistrationAction extends ActionSupport {

	/**
	 * @author ARJUN SINGH
	 */
	private static final long serialVersionUID = 2131578168004670047L;
	private Logger logger =  Logger.getLogger(RegistrationAction.class.getName());
	private RegistrationDTO registrationDTO;
	public RegistrationDTO getRegistrationDTO() {
		return registrationDTO;
	}

	public void setRegistrationDTO(RegistrationDTO registrationDTO) {
		this.registrationDTO = registrationDTO;
	}

	public String registerUser() {
		RegistrationDao registrationDao =  new RegistrationDao();
		int registrationStatus = 0;
		try {
			registrationStatus = registrationDao.save(registrationDTO);
			if(registrationStatus>0){
				logger.info("User registration successful!");
			}else{
				logger.info("User allready exist!");
			}
		} catch (SQLException sqlException ) {
			logger.info(sqlException.getMessage());
			return ERROR;
		} catch (IOException ioException) {
			logger.info(ioException.getMessage());
			return ERROR;
		} catch (Exception exception) {
			logger.info(exception.getMessage());
			return ERROR;
		} 
		return SUCCESS;

	}
}
