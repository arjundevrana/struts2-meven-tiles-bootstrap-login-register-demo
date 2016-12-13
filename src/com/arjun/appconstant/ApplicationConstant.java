package com.arjun.appconstant;

public class ApplicationConstant {
	public static final String DB_NAME="name";
	public static final String DB_USER_NAME="username";
	public static final String DB_PASSWORDE="password";
	public static final String SCHEMA_NAME="schemaname";
	public static final String SERVER_NAME="servername";
	public static final String PORT_NUMBER="portname";
	public static final String MD5_SALT="*&#$%@ds89*&dsg#$%%#@#";
	public static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
}
