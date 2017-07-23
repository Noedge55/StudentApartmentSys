package edu.sas.dao;

import java.util.List;


public interface IDAO<T,K> {
	public boolean doCreate(T vo) throws Exception;
	public boolean doUpdate(T vo) throws Exception;
	public boolean doRemove(K id) throws Exception;
	public T findById(K id) throws Exception;
	public List<T> findAll(String keyword) throws Exception;
	public int getAllCount(String keyword) throws Exception;
}
