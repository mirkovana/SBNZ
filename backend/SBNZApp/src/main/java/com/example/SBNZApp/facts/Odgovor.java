package com.example.SBNZApp.facts;


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
	
	@Column
	private boolean aktivanOdmor;
	
	@Column
	private boolean sunce;
	
	@Column
	private boolean voda;
	
	@Column
	private boolean dugPut;
	
	@Column
	private boolean svezVazduh;
	
	@Column
	private boolean individualniObilazak;
	
	@Column
	private boolean medNadzor;
	
	@Column
	private boolean znamenitosti;
	
	public Odgovor() {
	}

	public Odgovor(Long iD, boolean mir, boolean aktivanOdmor, boolean sunce, boolean voda, boolean dugPut, boolean svezVazduh, boolean individualniObilazak, boolean medNadzor, boolean znamenitosti) {
		super();
		ID = iD;
		this.mir = mir;
		this.aktivanOdmor = aktivanOdmor;
		this.sunce = sunce;
		this.dugPut = dugPut;
		this.svezVazduh = svezVazduh;
		this.individualniObilazak = individualniObilazak;
		this.medNadzor = medNadzor;
		this.znamenitosti = znamenitosti;
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

	public boolean isAktivanOdmor() {
		return aktivanOdmor;
	}

	public void setAktivanOdmor(boolean aktivanOdmor) {
		this.aktivanOdmor = aktivanOdmor;
	}

	public boolean isSunce() {
		return sunce;
	}

	public void setSunce(boolean sunce) {
		this.sunce = sunce;
	}

	public boolean isVoda() {
		return voda;
	}

	public void setVoda(boolean voda) {
		this.voda = voda;
	}

	public boolean isDugPut() {
		return dugPut;
	}

	public void setDugPut(boolean dugPut) {
		this.dugPut = dugPut;
	}

	public boolean isSvezVazduh() {
		return svezVazduh;
	}

	public void setSvezVazduh(boolean svezVazduh) {
		this.svezVazduh = svezVazduh;
	}

	public boolean isIndividualniObilazak() {
		return individualniObilazak;
	}

	public void setIndividualniObilazak(boolean individualniObilazak) {
		this.individualniObilazak = individualniObilazak;
	}

	public boolean isMedNadzor() {
		return medNadzor;
	}

	public void setMedNadzor(boolean medNadzor) {
		this.medNadzor = medNadzor;
	}

	public boolean isZnamenitosti() {
		return znamenitosti;
	}

	public void setZnamenitosti(boolean znamenitosti) {
		this.znamenitosti = znamenitosti;
	}
}
