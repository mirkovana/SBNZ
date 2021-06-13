package com.example.SBNZApp.facts;

public class SmestajAlarm {
	private Long userId;

	public SmestajAlarm() {
	}
	
	public SmestajAlarm(Long userId) {
		super();
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
