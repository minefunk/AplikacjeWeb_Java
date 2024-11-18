package jpa_temp;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the konkursy database table.
 * 
 */
@Entity
@NamedQuery(name="Konkursy.findAll", query="SELECT k FROM Konkursy k")
public class Konkursy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="konkurs_id")
	private int konkursId;

	@Temporal(TemporalType.DATE)
	@Column(name="data_rozpoczecia")
	private Date dataRozpoczecia;

	@Temporal(TemporalType.DATE)
	@Column(name="data_zakonczenia")
	private Date dataZakonczenia;

	private String nazwa;

	@Lob
	private String opis;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="utworzony_przez")
	private Uzytkownicy uzytkownicy;

	//bi-directional many-to-one association to Uczestnicy
	@OneToMany(mappedBy="konkursy")
	private List<Uczestnicy> uczestnicies;

	public Konkursy() {
	}

	public int getKonkursId() {
		return this.konkursId;
	}

	public void setKonkursId(int konkursId) {
		this.konkursId = konkursId;
	}

	public Date getDataRozpoczecia() {
		return this.dataRozpoczecia;
	}

	public void setDataRozpoczecia(Date dataRozpoczecia) {
		this.dataRozpoczecia = dataRozpoczecia;
	}

	public Date getDataZakonczenia() {
		return this.dataZakonczenia;
	}

	public void setDataZakonczenia(Date dataZakonczenia) {
		this.dataZakonczenia = dataZakonczenia;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Uzytkownicy getUzytkownicy() {
		return this.uzytkownicy;
	}

	public void setUzytkownicy(Uzytkownicy uzytkownicy) {
		this.uzytkownicy = uzytkownicy;
	}

	public List<Uczestnicy> getUczestnicies() {
		return this.uczestnicies;
	}

	public void setUczestnicies(List<Uczestnicy> uczestnicies) {
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