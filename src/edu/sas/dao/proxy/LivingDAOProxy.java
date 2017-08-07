package edu.sas.dao.proxy;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.ILivingDAO;
import edu.sas.dao.impl.LivingDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Dormitory;
import edu.sas.vo.Living;

public class LivingDAOProxy implements ILivingDAO{
	
	DatabaseConnection dbc = null;
	ILivingDAO dao = null;
	public LivingDAOProxy() {
		this.dbc = new DatabaseConnection();
		this.dao = new LivingDAOImpl(this.dbc.getConnection());
	}
	
	
	@Override
	public boolean doCreate(Living vo) throws Exception {
		return false;
	}

	@Override
	public boolean doUpdate(Living vo) throws Exception {
		
		return false;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Living findById(String id) throws Exception {
		Living vo = null;
		try{
			vo = this.dao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		return vo;
	}

	@Override
	public List<Living> findAll(String keyword) throws Exception {
		List<Living> list = null;
		try{
			list = this.dao.findAll(keyword);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Living> findAllPaging(String keyword, int pageNow, int pageSize) throws Exception {
		List<Living> list = new ArrayList<Living>();
		try{
			list = this.dao.findAllPaging(keyword, pageNow, pageSize);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.close();
		}
		return list;
	}

}
