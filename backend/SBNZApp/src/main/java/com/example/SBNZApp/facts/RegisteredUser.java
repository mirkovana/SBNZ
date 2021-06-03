package com.example.SBNZApp.facts;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;


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
	@Enumerated(EnumType.STRING)
	private TipKorisnika tipKorisnika;

	@Column
	private LocalDate vakcinacija;
	
	@Column
	private LocalDate datumRegistracije;
	
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
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "gost")
	@JsonBackReference
	private List<Putovanje> putovanja = new ArrayList<Putovanje>();
	
	@Column
	private int popust;
	
	public RegisteredUser(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public RegisteredUser() {
		super();
		this.datumRegistracije = LocalDate.now();
		this.popust = 0;
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

	public LocalDate getVakcinacija() {
		return vakcinacija;
	}

	public void setVakcinacija(LocalDate vakcinacija) {
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

	public LocalDate getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(LocalDate datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public List<Putovanje> getPutovanja() {
		return putovanja;
	}

	public void setPutovanja(List<Putovanje> putovanja) {
		this.putovanja = putovanja;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust += popust;
	}
	
	public void setPopustOgranicenje(int popust) {
		this.popust = popust;
	}
}
