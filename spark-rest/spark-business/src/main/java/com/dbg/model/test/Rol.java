package com.dbg.model.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The persistent class for the rol database table.
 * 
 */

@Entity(name = "tm_rol")
public class Rol   {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ROL")
	private int idRol;

	@Column(name="DESC_ROL")
	private String descRol;

	/**
	@OneToMany(mappedBy="rol")
	private List<TmUsua> tmUsuas;
*/
	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescRol() {
		return this.descRol;
	}

	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}
/*
	public List<TmUsua> getTmUsuas() {
		return this.tmUsuas;
	}

	public void setTmUsuas(List<TmUsua> tmUsuas) {
		this.tmUsuas = tmUsuas;
	}

	public TmUsua addTmUsua(TmUsua tmUsua) {
		getTmUsuas().add(tmUsua);
		tmUsua.setRol(this);

		return tmUsua;
	}

	public TmUsua removeTmUsua(TmUsua tmUsua) {
		getTmUsuas().remove(tmUsua);
		tmUsua.setRol(null);

		return tmUsua;
	}*/
	
	@Override
	public String toString() {
		return "Rol [id=" + idRol + ", desc=" + descRol + "]";
	}

}