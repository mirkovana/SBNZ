package com.example.SBNZApp.facts;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
@DiscriminatorValue("ROLE_USER")
public class RegisteredUser extends User {
	
	public enum Pol {
		MUSKO, ZENSKO
	};

	public enum TipLjubimca {
		MALI, VELIKI
	};

	public enum RadniStatus {
		STUDENT, ZAPOSLEN, NEZAPOSLEN, PENZIONER
	};
	// public enum BracniStatus {} mozda da je ozenjen kao sa porodicom

	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private int godiste;

	@Column
	@Enumerated(EnumType.STRING)
	private Pol pol;

	@Column
	@Enumerated(EnumType.STRING)
	private TipLjubimca tipLjubimca;

	@Column
	@Enumerated(EnumType.STRING)
	private RadniStatus radniStatus;

	@Column
	private Date vakcinacija;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_preferences",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "preference_id", referencedColumnName = "ID"))
	private Set<Karakteristika> preferences;
	
	@ManyToOne
	@JoinColumn(name = "idDestinacije", referencedColumnName = "ID", nullable = true)
	private Destinacija trenutnaDestinacija;
	
	@Transient
	private List<String> kar =new ArrayList<String>();
	
	public RegisteredUser(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public RegisteredUser() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public TipLjubimca getTipLjubimca() {
		return tipLjubimca;
	}

	public void setTipLjubimca(TipLjubimca tipLjubimca) {
		this.tipLjubimca = tipLjubimca;
	}

	public RadniStatus getRadniStatus() {
		return radniStatus;
	}

	public void setRadniStatus(RadniStatus radniStatus) {
		this.radniStatus = radniStatus;
	}

	public Date getVakcinacija() {
		return vakcinacija;
	}

	public void setVakcinacija(Date vakcinacija) {
		this.vakcinacija = vakcinacija;
	}

	public Set<Karakteristika> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<Karakteristika> preferences) {
		this.preferences = preferences;
	}
	
	public void addPreference(Karakteristika karakteristike) {
		this.getPreferences().add(karakteristike);
    }

	public List<String> getKar() {
		return kar;
	}

	public void setKar(List<String> kar) {
		this.kar = kar;
	}

	public Destinacija getTrenutnaDestinacija() {
		return trenutnaDestinacija;
	}

	public void setTrenutnaDestinacija(Destinacija trenutnaDestinacija) {
		this.trenutnaDestinacija = trenutnaDestinacija;
	}
}
