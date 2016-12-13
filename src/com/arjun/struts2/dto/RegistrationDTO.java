package com.arjun.struts2.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class RegistrationDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7875267859214369000L;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String invitationCode;
	private Timestamp createOn;
	private Timestamp updateON;
	private Timestamp deleteON;
	@Override
	public String toString() {
		return "RegistrationDTO [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", password=" + password + ", invitationCode=" + invitationCode + ", createOn=" + createOn
				+ ", updateON=" + updateON + ", deleteON=" + deleteON + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createOn == null) ? 0 : createOn.hashCode());
		result = prime * result + ((deleteON == null) ? 0 : deleteON.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((invitationCode == null) ? 0 : invitationCode.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((updateON == null) ? 0 : updateON.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationDTO other = (RegistrationDTO) obj;
		if (createOn == null) {
			if (other.createOn != null)
				return false;
		} else if (!createOn.equals(other.createOn))
			return false;
		if (deleteON == null) {
			if (other.deleteON != null)
				return false;
		} else if (!deleteON.equals(other.deleteON))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (invitationCode == null) {
			if (other.invitationCode != null)
				return false;
		} else if (!invitationCode.equals(other.invitationCode))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (updateON == null) {
			if (other.updateON != null)
				return false;
		} else if (!updateON.equals(other.updateON))
			return false;
		return true;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public Timestamp getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}
	public Timestamp getUpdateON() {
		return updateON;
	}
	public void setUpdateON(Timestamp updateON) {
		this.updateON = updateON;
	}
	public Timestamp getDeleteON() {
		return deleteON;
	}
	public void setDeleteON(Timestamp deleteON) {
		this.deleteON = deleteON;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
