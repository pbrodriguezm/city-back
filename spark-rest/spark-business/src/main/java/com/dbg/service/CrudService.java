package com.dbg.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.dbg.model.test.Rol;

public interface CrudService<T, PK extends Serializable> {

	T create(T t);

	T update(T t);

	T findById(PK id);

	void delete(T t);

	Collection<T> findAll();

	

}
