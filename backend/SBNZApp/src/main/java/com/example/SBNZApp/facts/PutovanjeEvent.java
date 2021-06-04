package com.example.SBNZApp.facts;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("10m")
public class PutovanjeEvent {

	private RegisteredUser user;

	public PutovanjeEvent(RegisteredUser user) {
		 
		this.user = user;
	}
	public PutovanjeEvent() {
		 
	
	}
	public RegisteredUser getUser() {
		return user;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}
	
}
