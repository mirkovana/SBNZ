package com.example.SBNZApp.facts;

public class LoginAlarm {
	private Long userID;
	
	public LoginAlarm() {
	}

	public LoginAlarm(Long userID) {
		super();
		this.userID = userID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}
}
