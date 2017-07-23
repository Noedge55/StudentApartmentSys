package edu.sas.dao.proxy;

import java.util.List;

import edu.sas.dao.IUsersDAO;
import edu.sas.dao.impl.UsersDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Users;

public class UsersDAOProxy implements IUsersDAO {
	private DatabaseConnection dbc = null;
	private IUsersDAO dao = null;
	public UsersDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.dao = new UsersDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Users vo) throws Exception {
		boolean flag = false;
		try{
			if(this.dao.findById(vo.getUserid()) == null){
				flag = this.doCreate(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Users vo) throws Exception {
		boolean flag = false ;
		try{
			flag = this.dao.doUpdate(vo);
		}catch(Exception e){
			e.printStackTrace(); 
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false ;
		try{
			flag = this.dao.doRemove(id);
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return flag ;
	}

	@Override
	public Users findById(String id) throws Exception {
		Users user = null;
		try{
			user = this.dao.findById(id);
		}catch (Exception e) {
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return user;
	}

	@Override
	public List<Users> findAll(String keyword) throws Exception {
		List<Users> list = null;
		try{
			list = this.dao.findAll(keyword);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0 ;
		try{
			count = this.dao.getAllCount(keyword);
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return count;
	}

	@Override
	public List<Users> findAll(Integer permission) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllCount(Integer permission) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean findLogin(String userid, String password) throws Exception {
		boolean flag = false;
		try{
			flag = this.dao.findLogin(userid, password);
		}catch(Exception e){
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return flag;
	}

}
