package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Set;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rola_id", unique=true, nullable=false)
	private int rolaId;

	@Column(nullable=false, length=50)
	private String nazwa;

	//bi-directional many-to-many association to Uzytkownicy
	@ManyToMany(mappedBy="roles")
	private Set<Uzytkownicy> uzytkownicies;

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

	public Set<Uzytkownicy> getUzytkownicies() {
		return this.uzytkownicies;
	}

	public void setUzytkownicies(Set<Uzytkownicy> uzytkownicies) {
		this.uzytkownicies = uzytkownicies;
	}

}