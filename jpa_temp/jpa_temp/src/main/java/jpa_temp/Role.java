package jpa_temp;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rola_id")
	private int rolaId;

	private String nazwa;

	//bi-directional many-to-many association to Uzytkownicy
	@ManyToMany(mappedBy="roles")
	private List<Uzytkownicy> uzytkownicies;

	public Role() {
	}

	public int getRolaId() {
		return this.rolaId;
	}

	public void setRolaId(int rolaId) {
		this.rolaId = rolaId;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Uzytkownicy> getUzytkownicies() {
		return this.uzytkownicies;
	}

	public void setUzytkownicies(List<Uzytkownicy> uzytkownicies) {
		this.uzytkownicies = uzytkownicies;
	}

}