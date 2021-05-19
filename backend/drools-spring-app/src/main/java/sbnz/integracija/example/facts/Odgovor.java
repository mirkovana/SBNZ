package sbnz.integracija.example.facts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Odgovor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column
	private boolean mir;
	
	public Odgovor() {
	}

	public Odgovor(Long iD, boolean mir) {
		super();
		ID = iD;
		this.mir = mir;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public boolean isMir() {
		return mir;
	}

	public void setMir(boolean mir) {
		this.mir = mir;
	}
}
