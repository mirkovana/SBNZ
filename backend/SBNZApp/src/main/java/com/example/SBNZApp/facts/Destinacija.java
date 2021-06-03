package com.example.SBNZApp.facts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Destinacija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(unique = true, nullable = false)
	private String naziv;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "destinacija_preferences",
            joinColumns = @JoinColumn(name = "destinacija_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "preference_id", referencedColumnName = "ID"))
	private Set<Karakteristika> preferences;
	
	@OneToMany(mappedBy = "destinacija")
	@JsonBackReference
	private Set<Smestaj> smestaji;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "trenutnaDestinacija")
	@JsonBackReference
	private Set<RegisteredUser> gosti = new HashSet<RegisteredUser>();

	public Destinacija() {
	}

	public Destinacija(Long iD, String naziv, Set<Karakteristika> preferences) {
        ID = iD;
		this.naziv = naziv;
		this.preferences = preferences;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Smestaj> getSmestaji() {
		return smestaji;
	}

	public void setSmestaji(Set<Smestaj> smestaji) {
		this.smestaji = smestaji;
	}

	public Set<Karakteristika> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<Karakteristika> preferences) {
		this.preferences = preferences;
	}

	public Set<RegisteredUser> getGosti() {
		return gosti;
	}

	public void setGosti(Set<RegisteredUser> gosti) {
		this.gosti = gosti;
	}
}
