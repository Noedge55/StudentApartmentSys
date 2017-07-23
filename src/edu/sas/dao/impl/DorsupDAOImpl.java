package edu.sas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.IDorsupDAO;
import edu.sas.vo.Dorsup;

public class DorsupDAOImpl implements IDorsupDAO {
	private Connection conn =null;
	private PreparedStatement pstmt = null;
	public DorsupDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Dorsup vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO dorsup(supno,supname,apartno,phonenum) VALUES(?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getSupno());
		this.pstmt.setString(2, vo.getSupname());
		this.pstmt.setString(3, vo.getApartno());
		this.pstmt.setString(4, vo.getPhonenum());
		if(this.pstmt.executeUpdate()>0){
			flag = true ;
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Dorsup vo) throws Exception {
		boolean flag = false ;
		String sql = "UPDATE dorsup SET apartno=?,phonenum=? WHERE supno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getApartno());
		this.pstmt.setString(2, vo.getPhonenum());
		this.pstmt.setString(3, vo.getSupno());
		if(this.pstmt.executeUpdate() > 0){
			flag = true ;
		}
		return flag;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false ;
		String sql = "DELETE FROM dorsup WHERE supno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if(this.pstmt.executeUpdate() > 0){
			flag = true ;
		}
		return flag ;
	}

	@Override
	public Dorsup findById(String id) throws Exception {
		Dorsup dorsup = null;
		String sql = "SELECT supno,supname,apartno,phonenum FROM dorsup WHERE supno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			dorsup = new Dorsup();
			dorsup.setSupno(rs.getString(1));
			dorsup.setSupname(rs.getString(2));
			dorsup.setApartno(rs.getString(3));
			dorsup.setPhonenum(rs.getString(4));
		}
		return dorsup;
	}

	@Override
	public List<Dorsup> findAll(String keyword) throws Exception {
		List<Dorsup> list = new ArrayList<>();
		String sql = "SELECT supno,supname,apartno,phonenum FROM dorsup WHERE supno LIKE ? OR supname LIKE ? OR apartno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		this.pstmt.setString(2, "%" + keyword + "%");
		this.pstmt.setString(3, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Dorsup dorsup = new Dorsup();
			dorsup.setSupno(rs.getString(1));
			dorsup.setSupname(rs.getString(2));
			dorsup.setApartno(rs.getString(3));
			dorsup.setPhonenum(rs.getString(4));
			list.add(dorsup);
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0;
		String sql = "SELECT COUNT(supno) WHERE supno LIKE ? OR supname LIKE ? OR apartno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		this.pstmt.setString(2, "%" + keyword + "%");
		this.pstmt.setString(3, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}

}
