package jpa_temp;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the uzytkownicy database table.
 * 
 */
@Entity
@NamedQuery(name="Uzytkownicy.findAll", query="SELECT u FROM Uzytkownicy u")
public class Uzytkownicy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uzytkownik_id")
	private int uzytkownikId;

	private String email;

	private String haslo;

	private String imie;

	private String nazwisko;

	//bi-directional many-to-one association to Konkursy
	@OneToMany(mappedBy="uzytkownicy")
	private List<Konkursy> konkursies;

	//bi-directional many-to-one association to Oceny
	@OneToMany(mappedBy="uzytkownicy")
	private List<Oceny> ocenies;

	//bi-directional many-to-one association to Uczestnicy
	@OneToMany(mappedBy="uzytkownicy")
	private List<Uczestnicy> uczestnicies;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="uzytkownicyrole"
		, joinColumns={
			@JoinColumn(name="uzytkownik_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rola_id")
			}
		)
	private List<Role> roles;

	public Uzytkownicy() {
	}

	public int getUzytkownikId() {
		return this.uzytkownikId;
	}

	public void setUzytkownikId(int uzytkownikId) {
		this.uzytkownikId = uzytkownikId;
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

	public List<Konkursy> getKonkursies() {
		return this.konkursies;
	}

	public void setKonkursies(List<Konkursy> konkursies) {
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

	public List<Oceny> getOcenies() {
		return this.ocenies;
	}

	public void setOcenies(List<Oceny> ocenies) {
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

	public List<Uczestnicy> getUczestnicies() {
		return this.uczestnicies;
	}

	public void setUczestnicies(List<Uczestnicy> uczestnicies) {
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

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}