package sbnz.integracija.example.facts;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

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

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "kolekcija", joinColumns = @JoinColumn(name = "ID"))
	@Enumerated(EnumType.STRING)
	private List<Karakteristike> preferences;

	public RegisteredUser() {
		super();
	}

	public RegisteredUser(String name, String surname, int godiste, Pol pol, TipLjubimca tipLjubimca,
			RadniStatus radniStatus, Date vakcinacija) {
		super();
		this.name = name;
		this.surname = surname;
		this.godiste = godiste;
		this.pol = pol;
		this.tipLjubimca = tipLjubimca;
		this.radniStatus = radniStatus;
		this.vakcinacija = vakcinacija;
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
	
	public List<Karakteristike> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Karakteristike> preferences) {
		this.preferences = preferences;
	}

	public void addPreference(Karakteristike karakteristike) {
			this.getPreferences().add(karakteristike);
	}
}
