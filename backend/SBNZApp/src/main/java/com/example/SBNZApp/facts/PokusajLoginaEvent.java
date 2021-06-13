package com.example.SBNZApp.facts;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("1m")
public class PokusajLoginaEvent {
	
	private User user;
	
	public PokusajLoginaEvent() {
	}

	public PokusajLoginaEvent(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
