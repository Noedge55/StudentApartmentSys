package edu.sas.dao;

import java.util.List;

import edu.sas.vo.Users;

public interface IUsersDAO extends IDAO<Users,String>{
	public List<Users> findAll(Integer permission) throws Exception;
	public int getAllCount(Integer permission) throws Exception;
	public boolean findLogin(String userid,String password) throws Exception;
}
