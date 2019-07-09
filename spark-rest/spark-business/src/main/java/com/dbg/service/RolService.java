package com.dbg.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dbg.dao.RolDao;
import com.dbg.model.test.Rol;

public class RolService implements CrudService<Rol, Integer> {

	private RolDao rolDao;
	private List roles = new ArrayList<Rol>();

	public RolService() {
		rolDao = new RolDao();
	}

	@Override
	public Rol create(Rol t) {
		return rolDao.create(t);
	}

	@Override
	public Rol update(Rol t) {
		return rolDao.update(t);
	}

	@Override
	public Rol findById(Integer id) {
		return rolDao.findById(id);
	}

	@Override
	public void delete(Rol t) {
		rolDao.delete(t);
	}
	
	@Override
	public Collection<Rol> findAll() {
		
		return rolDao.getAll();
	}

}