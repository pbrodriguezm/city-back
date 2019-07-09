package com.dbg.model.test;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tm_usua database table.
 * 
 */
@Entity
@Table(name="tm_usua")
@NamedQuery(name="TmUsua.findAll", query="SELECT t FROM TmUsua t")
public class TmUsua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUA")
	private int idUsua;

	@Column(name="NB_USUA")
	private String nbUsua;

	@Column(name="PW_USUA")
	private String pwUsua;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol rol;

	//bi-directional many-to-one association to TmPer
	@ManyToOne
	@JoinColumn(name="TM_PERS_ID_PERS")
	private TmPer tmPer;

	public TmUsua() {
	}

	public int getIdUsua() {
		return this.idUsua;
	}

	public void setIdUsua(int idUsua) {
		this.idUsua = idUsua;
	}

	public String getNbUsua() {
		return this.nbUsua;
	}

	public void setNbUsua(String nbUsua) {
		this.nbUsua = nbUsua;
	}

	public String getPwUsua() {
		return this.pwUsua;
	}

	public void setPwUsua(String pwUsua) {
		this.pwUsua = pwUsua;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public TmPer getTmPer() {
		return this.tmPer;
	}

	public void setTmPer(TmPer tmPer) {
		this.tmPer = tmPer;
	}

}