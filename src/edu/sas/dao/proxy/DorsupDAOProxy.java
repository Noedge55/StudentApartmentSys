package edu.sas.dao.proxy;

import java.util.List;

import edu.sas.dao.IDorsupDAO;
import edu.sas.dao.impl.DorsupDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Dorsup;

public class DorsupDAOProxy implements IDorsupDAO {
	private DatabaseConnection dbc = null;
	private IDorsupDAO dao = null;
	public DorsupDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.dao = new DorsupDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Dorsup vo) throws Exception {
		boolean flag = false;
		try{
			if(this.dao.findById(vo.getSupno()) == null){
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
	public boolean doUpdate(Dorsup vo) throws Exception {
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
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag ;
	}

	@Override
	public Dorsup findById(String id) throws Exception {
		Dorsup dorsup = null;
		try{
			dorsup = this.dao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return dorsup;
	}

	@Override
	public List<Dorsup> findAll(String keyword) throws Exception {
		List<Dorsup> list = null;
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
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return count;
	}

}
