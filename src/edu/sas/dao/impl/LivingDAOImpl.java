package edu.sas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import edu.sas.dao.ILivingDAO;
import edu.sas.vo.Living;

public class LivingDAOImpl implements ILivingDAO{
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public LivingDAOImpl(Connection conn) {
		this.conn = conn ;
	}
	
	@Override
	public boolean doCreate(Living vo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO living(livno,stuno,dorno,intime,outime) VALUES (?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getLivno());
		this.pstmt.setString(2, vo.getStuno());
		this.pstmt.setString(3, vo.getDorno());
		this.pstmt.setDate(4, new java.sql.Date(vo.getIntime().getTime()));
		this.pstmt.setDate(5, new java.sql.Date(vo.getOutime().getTime()));
		if(this.pstmt.executeUpdate() > 0){
			flag = true ;
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Living vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Living findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Living> findAll(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
