package mz.co.computinglabs.lucros.dao;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import mz.co.computinglabs.lucros.entity.AbstractEntity;
 



/**
 * this  class is  an implementation of common methods  that my occur in 
 * object. All methods in here are applied for  subclasses of  AbstractEntity 
 * 
 * @author Clerio Alfredo Faife
 *
 *
 */
@Repository
public class GenericDAOImpl<T extends AbstractEntity> implements IGenericDAO<T>{

	@PersistenceContext
	private EntityManager em;
	
	
	public T create(T t) {
		t.setDateCreated(LocalDateTime.now());
		t.setActive(true);
		t.setCreatedBy(1L);
		em.persist(t);
		return t;
	}

	
	public T update(T t) {
		t.setDateUpdated(LocalDateTime.now());
		em.merge(t);
		return t;
	}

	
	public T remove(T t) throws Exception {
		
		if(t.isActive()) {
		
			t.setActive(false);
			em.merge(t);
			return t;
		}
		throw new Exception("LucrosStockAPIException: unable to already inactivated entity");
		
	}

	@SuppressWarnings("unchecked")
	
	public Collection<T> findAll(Class<T> clazz, boolean active) {
		Query q = em.createQuery("select  t  from "+clazz.getSimpleName()+" t where t.active = :active" );
		q.setParameter("active", active);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	
	public Collection<T> findAny(Class<T> clazz) {
		Query q = em.createQuery("select  t  from "+clazz.getSimpleName()+" t" );
		return q.getResultList();
	}


	@SuppressWarnings("unchecked")
	
	public T findById(Class<T> clazz, long id, boolean active) {
		Query q = em.createQuery("select  t  from "+clazz.getSimpleName()+" t where t.id = :id and t.active = :active" );
		q.setParameter("id", id);
		q.setParameter("active", active);
		return (T) q.getSingleResult();
	}
	


}
