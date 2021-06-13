package com.example.SBNZApp.facts;

public class AlarmTriggered {

	private Long customerId;

	public AlarmTriggered() {
	}
	
	public AlarmTriggered(Long customerId) {
		super();
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
}
