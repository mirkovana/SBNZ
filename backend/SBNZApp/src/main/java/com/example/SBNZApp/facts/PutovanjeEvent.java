package com.example.SBNZApp.facts;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Expires("10m")
public class PutovanjeEvent {
//@Timestamp("executionTime")
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
