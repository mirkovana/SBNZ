package com.example.SBNZApp.facts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.SBNZApp.facts.RegisteredUser.Pol;
import com.example.SBNZApp.facts.RegisteredUser.RadniStatus;
import com.example.SBNZApp.facts.RegisteredUser.TipLjubimca;

public class TrenutniUser {
	
	private int godiste;

	private Pol pol;

	private TipLjubimca tipLjubimca;

	private RadniStatus radniStatus;
	
	private List<RegisteredUser> slicni =new ArrayList<RegisteredUser>();
	
	private Set<Smestaj> preporuceniSmestaj =new HashSet<Smestaj>();
	
	private Destinacija trenutnaDestinacija;
	
	public TrenutniUser() {
	}

	public TrenutniUser(int godiste, Pol pol, TipLjubimca tipLjubimca, RadniStatus radniStatus, Destinacija trenutnaDestinacija) {
		this.godiste = godiste;
		this.pol = pol;
		this.tipLjubimca = tipLjubimca;
		this.radniStatus = radniStatus;
		this.trenutnaDestinacija = trenutnaDestinacija;
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

	public List<RegisteredUser> getSlicni() {
		return slicni;
	}

	public void setSlicni(List<RegisteredUser> slicni) {
		this.slicni = slicni;
	}

	public Destinacija getTrenutnaDestinacija() {
		return trenutnaDestinacija;
	}

	public void setTrenutnaDestinacija(Destinacija trenutnaDestinacija) {
		this.trenutnaDestinacija = trenutnaDestinacija;
	}

	public Set<Smestaj> getPreporuceniSmestaj() {
		return preporuceniSmestaj;
	}

	public void setPreporuceniSmestaj(Set<Smestaj> preporuceniSmestaj) {
		this.preporuceniSmestaj = preporuceniSmestaj;
	}
}
