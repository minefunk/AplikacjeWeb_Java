package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the uprawnienia_moderatora database table.
 * 
 */
@Entity
@Table(name="uprawnienia_moderatora")
@NamedQuery(name="UprawnieniaModeratora.findAll", query="SELECT u FROM UprawnieniaModeratora u")
public class UprawnieniaModeratora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uprawnienie_id", unique=true, nullable=false)
	private int uprawnienieId;

	@Column(name="data_nadania", nullable=false)
	private Timestamp dataNadania;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="admin_id", nullable=false)
	private Uzytkownicy uzytkownicy1;

	//bi-directional many-to-one association to Uzytkownicy
	@ManyToOne
	@JoinColumn(name="moderator_id", nullable=false)
	private Uzytkownicy uzytkownicy2;

	public UprawnieniaModeratora() {
	}

	public int getUprawnienieId() {
		return this.uprawnienieId;
	}

	public void setUprawnienieId(int uprawnienieId) {
		this.uprawnienieId = uprawnienieId;
	}

	public Timestamp getDataNadania() {
		return this.dataNadania;
	}

	public void setDataNadania(Timestamp dataNadania) {
		this.dataNadania = dataNadania;
	}

	public Uzytkownicy getUzytkownicy1() {
		return this.uzytkownicy1;
	}

	public void setUzytkownicy1(Uzytkownicy uzytkownicy1) {
		this.uzytkownicy1 = uzytkownicy1;
	}

	public Uzytkownicy getUzytkownicy2() {
		return this.uzytkownicy2;
	}

	public void setUzytkownicy2(Uzytkownicy uzytkownicy2) {
		this.uzytkownicy2 = uzytkownicy2;
	}

}