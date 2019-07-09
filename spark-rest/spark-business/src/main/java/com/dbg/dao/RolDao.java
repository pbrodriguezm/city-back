package com.dbg.dao;

import com.dbg.model.test.Persona;
import com.dbg.model.test.Rol;


public class RolDao extends HibernateAbstractDao<Rol, Integer> {

	@Override
	public Class<?> getClazz() {
		return Rol.class;
	}

}