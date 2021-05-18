package sbnz.integracija.example.facts;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROLE_ADMIN")
public class Admin extends User{
	
	@Column
	private String brojTelefona;
	
	public Admin() {
		super();
	}

	public Admin(String brojTelefona) {
		super();
		this.brojTelefona = brojTelefona;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
}
