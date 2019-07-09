package com.dbg.model.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "persona")
public class Persona {

	@Id
	@GeneratedValue
	private Integer id;

	private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}

}
