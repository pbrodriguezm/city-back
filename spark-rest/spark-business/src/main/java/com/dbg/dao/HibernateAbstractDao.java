package com.dbg.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;


public abstract class HibernateAbstractDao<T, PK extends Serializable>
		implements HibernateDao<T, PK> {

	private EntityManagerFactory entityManagerFactory;

	public HibernateAbstractDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	}

	protected EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	@Override
	public T create(T t) {
		final EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return t;
	}

	@Override
	public T update(T t) {
		final EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(PK id) {
		final EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			final T obj = (T) em.find(getClazz(), id);
			em.getTransaction().commit();
			return obj;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}
	
	
	  public Collection<T> getAll() {
		
		
		final EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			 CriteriaBuilder cb = em.getCriteriaBuilder();
			 CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(getClazz());
			 Root<T> rootEntry = (Root<T>) cq.from(getClazz());
			 CriteriaQuery<T> all = cq.select(rootEntry);
			 TypedQuery<T> allQuery = em.createQuery(all);
			 return allQuery.getResultList();			 
			
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
		
	   }
	
	/*
	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}
*/
	

	@Override
	public void delete(T t) {
		final EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(t) ? t : em.merge(t));
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}

	public abstract Class<?> getClazz();

}
