package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the konkursy database table.
 * 
 */
@Entity
@Table(name="konkursy")
@NamedQuery(name="Konkursy.findAll", query="SELECT k FROM Konkursy k")
public class Konkursy implements Serializable {
	private static final long serialVersionUID = 1L;
	private int konkursId;
	private Date dataRozpoczecia;
	private Date dataZakonczenia;
	private String nazwa;
	private String opis;
	private Uzytkownicy uzytkownicy;
	private Set<Uczestnicy> uczestnicies;

	public Konkursy() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="konkurs_id", unique=true, nullable=false)
	public int getKonkursId() {
		return this.konkursId;
	}

	public void setKonkursId(int konkursId) {
		this.konkursId = konkursId;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="data_rozpoczecia")
	public Date getDataRozpoczecia() {
		return this.dataRozpoczecia;
	}

	public void setDataRozpoczecia(Date dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="data_zakonczenia")
	public Date getDataZakonczenia() {
		return this.dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}


	@Column(nullable=false, length=100)
	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}


	@Lob
	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}


	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="utworzony_przez", nullable=false)
	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}


	//bi-directional many-to-one association to Uczestnicy
	@OneToMany(mappedBy="konkursy")
	public Set<Uczestnicy> getUczestnicies() {
		return this.uczestnicies;
	}

	public void setUczestnicies(Set<Uczestnicy> uczestnicies) {
		this.uczestnicies = uczestnicies;
	}

	public Uczestnicy addUczestnicy(Uczestnicy uczestnicy) {
		getUczestnicies().add(uczestnicy);
		uczestnicy.setKonkursy(this);

		return uczestnicy;
	}

	public Uczestnicy removeUczestnicy(Uczestnicy uczestnicy) {
		getUczestnicies().remove(uczestnicy);
		uczestnicy.setKonkursy(null);

		return uczestnicy;
	}

}