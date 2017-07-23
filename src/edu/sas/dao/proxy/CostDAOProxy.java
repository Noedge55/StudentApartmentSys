package edu.sas.dao.proxy;

import java.util.List;


import edu.sas.dao.ICostDAO;
import edu.sas.dao.impl.CostDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Cost;

public class CostDAOProxy implements ICostDAO {
	private DatabaseConnection dbc = null;
	private ICostDAO dao = null;
	public CostDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.dao = new CostDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Cost vo) throws Exception {
		boolean flag = false ;
		try{
			if(this.dao.findById(vo.getCostno()) == null){
				flag = this.dao.doCreate(vo);
			}
		}catch(Exception e){
			e.printStackTrace(); 
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Cost vo) throws Exception {
		boolean flag = false ;
		try{
			flag = this.dao.doUpdate(vo);
		}catch(Exception e){
			throw e; 
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
	public Cost findById(String id) throws Exception {
		Cost cost = null;
		try{
			cost = this.dao.findById(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return cost;
	}

	@Override
	public List<Cost> findAll(String keyword) throws Exception {
		List<Cost> list = null ;
		try{
			list = this.dao.findAll(keyword);
		}catch(Exception e){
			throw e;
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
