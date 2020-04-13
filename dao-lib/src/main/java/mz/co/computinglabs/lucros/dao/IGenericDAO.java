package mz.co.computinglabs.lucros.dao;

import java.util.Collection;

 
 
public interface IGenericDAO<T> {
	
	T create(T t);
	
	T update(T t);
	
	T remove(T t) throws Exception;
	
	Collection<T> findAll(Class<T> clazz,boolean active);
	
	Collection<T> findAny(Class<T> clazz);
	
	T findById(Class<T> clazz, long id,boolean active);
	
}
