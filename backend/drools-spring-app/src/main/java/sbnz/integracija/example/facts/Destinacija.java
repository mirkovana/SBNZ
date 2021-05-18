package sbnz.integracija.example.facts;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Destinacija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(unique = true, nullable = false)
	private String naziv;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "kolekcija", joinColumns = @JoinColumn(name = "ID"))
	@Enumerated(EnumType.STRING)
	private List<Karakteristike> karakteristike;
	
	@OneToMany(mappedBy = "destinacija")
	@JsonBackReference
	private Set<Smestaj> smestaji;
	
	public Destinacija() {
	}

	public Destinacija(Long iD, String naziv, List<Karakteristike> karakteristike) {
        ID = iD;
		this.naziv = naziv;
		this.karakteristike = karakteristike;
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

	public List<Karakteristike> getKarakteristike() {
		return karakteristike;
	}

	public void setKarakteristike(List<Karakteristike> karakteristike) {
		this.karakteristike = karakteristike;
	}

	public Set<Smestaj> getSmestaji() {
		return smestaji;
	}

	public void setSmestaji(Set<Smestaj> smestaji) {
		this.smestaji = smestaji;
	}
}
