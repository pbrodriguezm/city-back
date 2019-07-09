package com.dbg.service;

import java.util.Collection;
import java.util.List;

import com.dbg.dao.PersonaDao;
import com.dbg.dao.test.TestDao;
import com.dbg.model.test.Persona;
import com.dbg.model.test.Rol;
import com.dbg.model.test.Test;
import com.dbg.model.test.TmPer;

public class PersonaService implements CrudService<TmPer, Integer> {

	private PersonaDao personaDao;

	public PersonaService() {
		personaDao = new PersonaDao();
	}

	@Override
	public TmPer create(TmPer t) {
		return personaDao.create(t);
	}

	@Override
	public TmPer update(TmPer t) {
		return personaDao.update(t);
	}

	@Override
	public TmPer findById(Integer id) {
		return personaDao.findById(id);
	}

	@Override
	public void delete(TmPer t) {
		personaDao.delete(t);
	}

	@Override
	public Collection<TmPer> findAll() {
		return personaDao.getAll();
	}




}