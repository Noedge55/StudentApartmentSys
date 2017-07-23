package edu.sas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.IDormitoryDAO;
import edu.sas.vo.Dormitory;

public class DormitoryDAOImpl implements IDormitoryDAO {
	private Connection conn = null ;
	private PreparedStatement pstmt = null;
	public DormitoryDAOImpl(Connection conn) {
		this.conn = conn ;
	}
	@Override
	public boolean doCreate(Dormitory vo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO dormitory(dorno,apartno,stutotnum,stulivnum,stuno) values (?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getDorno());
		this.pstmt.setString(2, vo.getApartno());
		this.pstmt.setInt(3, vo.getStutotnum());
		this.pstmt.setInt(4, vo.getStulivnum());
		this.pstmt.setString(5, vo.getStuno());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Dormitory vo) throws Exception {
		boolean flag = false ;
		String sql = "UPDATE dormitory SET stutotnum = ?,stuno = ? where dorno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getStutotnum());
		this.pstmt.setString(2, vo.getStuno());
		this.pstmt.setString(3, vo.getDorno());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false ;
		String sql = "DELETE FROM dormitory WHERE dorno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public Dormitory findById(String id) throws Exception {
		Dormitory dormitory = null;
		String sql = "SELECT dorno,apartno,stutotnum,stulivnum,stuno FROM dormitory WHERE dorno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			dormitory = new Dormitory();
			dormitory.setDorno(rs.getString(1));
			dormitory.setApartno(rs.getString(2));
			dormitory.setStutotnum(rs.getInt(3));
			dormitory.setStulivnum(rs.getInt(4));
			dormitory.setStuno(rs.getString(5));
		}
		return dormitory;
	}

	@Override
	public List<Dormitory> findAll(String keyword) throws Exception {
		List<Dormitory> list = new ArrayList<Dormitory>();
		String sql = "select dorno,apartno,stutotnum,stulivnum,stuno FROM dormitory WHERE dorno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Dormitory dormitory = new Dormitory();
			dormitory.setDorno(rs.getString(1));
			dormitory.setApartno(rs.getString(2));
			dormitory.setStutotnum(rs.getInt(3));
			dormitory.setStulivnum(rs.getInt(4));
			dormitory.setStuno(rs.getString(5));
			list.add(dormitory);
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0 ;
		String sql = "SELECT COUNT(dorno) FROM dormitory WHERE dorno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
	@Override
	public List<Dormitory> findAllPaging(String keyword, int pageNow, int pageSize) throws Exception {
		List<Dormitory> list = new ArrayList<Dormitory>();
		String sql = "select dorno,apartno,stutotnum,stulivnum,stuno FROM dormitory WHERE dorno LIKE ? LIMIT ?,?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		this.pstmt.setInt(2, (pageNow-1)*pageSize);
		this.pstmt.setInt(3, pageSize);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Dormitory dormitory = new Dormitory();
			dormitory.setDorno(rs.getString(1));
			dormitory.setApartno(rs.getString(2));
			dormitory.setStutotnum(rs.getInt(3));
			dormitory.setStulivnum(rs.getInt(4));
			dormitory.setStuno(rs.getString(5));
			list.add(dormitory);
		}
		return list;
	}

}
