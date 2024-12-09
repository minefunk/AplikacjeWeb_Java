package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the uzytkownicy database table.
 * 
 */
@Entity
@Table(name="uzytkownicy")
@NamedQuery(name="Uzytkownicy.findAll", query="SELECT u FROM Uzytkownicy u")
public class Uzytkownicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uzytkownik_id", unique=true, nullable=false)
	private int uzytkownikId;

	@Column(name="data_utworzenia", nullable=false)
	private Timestamp dataUtworzenia;

	@Column(nullable=false, length=100)
	private String email;

	@Column(nullable=false, length=255)
	private String haslo;

	@Column(nullable=false, length=50)
	private String imie;

	@Column(nullable=false, length=50)
	private String nazwisko;

	//bi-directional many-to-one association to Konkursy
	@OneToMany(mappedBy="uzytkownicy")
	private Set<Konkursy> konkursies;

	//bi-directional many-to-one association to Oceny
	@OneToMany(mappedBy="uzytkownicy")
	private Set<Oceny> ocenies;

	//bi-directional many-to-one association to Uczestnicy
	@OneToMany(mappedBy="uzytkownicy")
	private Set<Uczestnicy> uczestnicies;

	//bi-directional many-to-one association to UprawnieniaModeratora
	@OneToMany(mappedBy="uzytkownicy1")
	private Set<UprawnieniaModeratora> uprawnieniaModeratoras1;

	//bi-directional many-to-one association to UprawnieniaModeratora
	@OneToMany(mappedBy="uzytkownicy2")
	private Set<UprawnieniaModeratora> uprawnieniaModeratoras2;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="uzytkownicyrole"
		, joinColumns={
			@JoinColumn(name="uzytkownik_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="rola_id", nullable=false)
			}
		)
	private Set<Role> roles;

	public Uzytkownicy() {
	}

	public int getUzytkownikId() {
		return this.uzytkownikId;
	}

	public void setUzytkownikId(int uzytkownikId) {
		this.uzytkownikId = uzytkownikId;
	}

	public Timestamp getDataUtworzenia() {
		return this.dataUtworzenia;
	}

	public void setDataUtworzenia(Timestamp dataUtworzenia) {
		this.dataUtworzenia = dataUtworzenia;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
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

	public Set<Konkursy> getKonkursies() {
		return this.konkursies;
	}

	public void setKonkursies(Set<Konkursy> konkursies) {
		this.konkursies = konkursies;
	}

	public Konkursy addKonkursy(Konkursy konkursy) {
		getKonkursies().add(konkursy);
		konkursy.setUzytkownicy(this);

		return konkursy;
	}

	public Konkursy removeKonkursy(Konkursy konkursy) {
		getKonkursies().remove(konkursy);
		konkursy.setUzytkownicy(null);

		return konkursy;
	}

	public Set<Oceny> getOcenies() {
		return this.ocenies;
	}

	public void setOcenies(Set<Oceny> ocenies) {
		this.ocenies = ocenies;
	}

	public Oceny addOceny(Oceny oceny) {
		getOcenies().add(oceny);
		oceny.setUzytkownicy(this);

		return oceny;
	}

	public Oceny removeOceny(Oceny oceny) {
		getOcenies().remove(oceny);
		oceny.setUzytkownicy(null);

		return oceny;
	}

	public Set<Uczestnicy> getUczestnicies() {
		return this.uczestnicies;
	}

	public void setUczestnicies(Set<Uczestnicy> uczestnicies) {
		this.uczestnicies = uczestnicies;
	}

	public Uczestnicy addUczestnicy(Uczestnicy uczestnicy) {
		getUczestnicies().add(uczestnicy);
		uczestnicy.setUzytkownicy(this);

		return uczestnicy;
	}

	public Uczestnicy removeUczestnicy(Uczestnicy uczestnicy) {
		getUczestnicies().remove(uczestnicy);
		uczestnicy.setUzytkownicy(null);

		return uczestnicy;
	}

	public Set<UprawnieniaModeratora> getUprawnieniaModeratoras1() {
		return this.uprawnieniaModeratoras1;
	}

	public void setUprawnieniaModeratoras1(Set<UprawnieniaModeratora> uprawnieniaModeratoras1) {
		this.uprawnieniaModeratoras1 = uprawnieniaModeratoras1;
	}

	public UprawnieniaModeratora addUprawnieniaModeratoras1(UprawnieniaModeratora uprawnieniaModeratoras1) {
		getUprawnieniaModeratoras1().add(uprawnieniaModeratoras1);
		uprawnieniaModeratoras1.setUzytkownicy1(this);

		return uprawnieniaModeratoras1;
	}

	public UprawnieniaModeratora removeUprawnieniaModeratoras1(UprawnieniaModeratora uprawnieniaModeratoras1) {
		getUprawnieniaModeratoras1().remove(uprawnieniaModeratoras1);
		uprawnieniaModeratoras1.setUzytkownicy1(null);

		return uprawnieniaModeratoras1;
	}

	public Set<UprawnieniaModeratora> getUprawnieniaModeratoras2() {
		return this.uprawnieniaModeratoras2;
	}

	public void setUprawnieniaModeratoras2(Set<UprawnieniaModeratora> uprawnieniaModeratoras2) {
		this.uprawnieniaModeratoras2 = uprawnieniaModeratoras2;
	}

	public UprawnieniaModeratora addUprawnieniaModeratoras2(UprawnieniaModeratora uprawnieniaModeratoras2) {
		getUprawnieniaModeratoras2().add(uprawnieniaModeratoras2);
		uprawnieniaModeratoras2.setUzytkownicy2(this);

		return uprawnieniaModeratoras2;
	}

	public UprawnieniaModeratora removeUprawnieniaModeratoras2(UprawnieniaModeratora uprawnieniaModeratoras2) {
		getUprawnieniaModeratoras2().remove(uprawnieniaModeratoras2);
		uprawnieniaModeratoras2.setUzytkownicy2(null);

		return uprawnieniaModeratoras2;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}