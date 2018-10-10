package com.assignment.cs.emp.service;

import java.util.List;

/**
 * 
 * @author sanjib.pramanick
 *
 * @param <T>
 */
public interface GenericService<T> {

	public T create(T obj);

	public List<T> findAll();

	public T update(T obj);

	public T delete(T obj);

}
