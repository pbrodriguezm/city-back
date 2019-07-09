package com.dbg.dao;


import com.dbg.model.test.TmPer;


public class PersonaDao extends HibernateAbstractDao<TmPer, Integer> {

	@Override
	public Class<?> getClazz() {
		return TmPer.class;
	}

}