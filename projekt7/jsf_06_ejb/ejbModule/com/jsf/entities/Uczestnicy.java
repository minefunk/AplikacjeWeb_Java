package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Set;


/**
 * The persistent class for the uczestnicy database table.
 * 
 */
@Entity
@Table(name="uczestnicy")
@NamedQuery(name="Uczestnicy.findAll", query="SELECT u FROM Uczestnicy u")
public class Uczestnicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uczestnik_id", unique=true, nullable=false)
	private int uczestnikId;

	@Column(nullable=false, length=100)
	private String email;

	@Column(nullable=false, length=50)
	private String imie;

	@Column(nullable=false, length=50)
	private String nazwisko;

	@Lob
	private String opis;

	//bi-directional many-to-one association to Oceny
	@OneToMany(mappedBy="uczestnicy")
	private Set<Oceny> ocenies;

	//bi-directional many-to-one association to Konkursy
	@ManyToOne
	@JoinColumn(name="konkurs_id", nullable=false)
	private Konkursy konkursy;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="utworzony_przez", nullable=false)
	private Uzytkownicy uzytkownicy;

	public Uczestnicy() {
	}

	public int getUczestnikId() {
		return this.uczestnikId;
	}

	public void setUczestnikId(int uczestnikId) {
		this.uczestnikId = uczestnikId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Set<Oceny> getOcenies() {
		return this.ocenies;
	}

	public void setOcenies(Set<Oceny> ocenies) {
		this.ocenies = ocenies;
	}

	public Oceny addOceny(Oceny oceny) {
		getOcenies().add(oceny);
		oceny.setUczestnicy(this);

		return oceny;
	}

	public Oceny removeOceny(Oceny oceny) {
		getOcenies().remove(oceny);
		oceny.setUczestnicy(null);

		return oceny;
	}

	public Konkursy getKonkursy() {
		return this.konkursy;
	}

	public void setKonkursy(Konkursy konkursy) {
		this.konkursy = konkursy;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}