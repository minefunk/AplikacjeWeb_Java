package jpa_temp;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the oceny database table.
 * 
 */
@Entity
@NamedQuery(name="Oceny.findAll", query="SELECT o FROM Oceny o")
public class Oceny implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ocena_id")
	private int ocenaId;

	@Column(name="wartosc_oceny")
	private int wartoscOceny;

	//bi-directional many-to-one association to Uczestnicy
	@ManyToOne
	@JoinColumn(name="uczestnik_id")
	private Uczestnicy uczestnicy;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="oceniony_przez")
	private Uzytkownicy uzytkownicy;

	public Oceny() {
	}

	public int getOcenaId() {
		return this.ocenaId;
	}

	public void setOcenaId(int ocenaId) {
		this.ocenaId = ocenaId;
	}

	public int getWartoscOceny() {
		return this.wartoscOceny;
	}

	public void setWartoscOceny(int wartoscOceny) {
		this.wartoscOceny = wartoscOceny;
	}

	public Uczestnicy getUczestnicy() {
		return this.uczestnicy;
	}

	public void setUczestnicy(Uczestnicy uczestnicy) {
		this.uczestnicy = uczestnicy;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

}