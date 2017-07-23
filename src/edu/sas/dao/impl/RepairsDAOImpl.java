package edu.sas.dao.impl;
/**
 * 物品维修表操作实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.IRepairsDAO;
import edu.sas.vo.Repairs;

public class RepairsDAOImpl implements IRepairsDAO {
	private Connection conn =null;
	private PreparedStatement pstmt = null;
	public RepairsDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Repairs vo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO repairs(repno,dorno,gname,writime,reptime,isrepair,reptext) VALUES(?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getRepno());
		this.pstmt.setString(2, vo.getDorno());
		this.pstmt.setString(3, vo.getGname());
		this.pstmt.setDate(4, new java.sql.Date(vo.getWritime().getTime()));
		this.pstmt.setDate(5, new java.sql.Date(vo.getReptime().getTime()));
		this.pstmt.setBoolean(6, vo.isRepair());
		this.pstmt.setString(7, vo.getReptext());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag ;
	}

	@Override
	public boolean doUpdate(Repairs vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE repairs SET gname=?,writime=?,reptime=?,isrepair=?,reptext=? WHRER repno = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getGname());
		this.pstmt.setDate(2, new java.sql.Date(vo.getWritime().getTime()));
		this.pstmt.setDate(3, new java.sql.Date(vo.getReptime().getTime()));
		this.pstmt.setBoolean(4, vo.isRepair());
		this.pstmt.setString(5, vo.getReptext());
		this.pstmt.setString(6, vo.getRepno());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM repairs WHRER repno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public Repairs findById(String id) throws Exception {
		Repairs repair = null;
		String sql = "SELECT repno,dorno,gname,writime,reptime,isrepair,reptext WHERE repno = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			repair = new Repairs();
			repair.setRepno(rs.getString(1));
			repair.setDorno(rs.getString(2));
			repair.setGname(rs.getString(3));
			repair.setWritime(rs.getDate(4));
			repair.setReptime(rs.getDate(5));
			repair.setRepair(rs.getBoolean(6));
			repair.setReptext(rs.getString(7));
		}
		return repair;
	}

	@Override
	public List<Repairs> findAll(String keyword) throws Exception {
		List<Repairs> list = new ArrayList<>();
		String sql = "SELECT repno,dorno,gname,writime,reptime,isrepair,reptext WHERE dorno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+keyword+"%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Repairs repair = new Repairs();
			repair.setRepno(rs.getString(1));
			repair.setDorno(rs.getString(2));
			repair.setGname(rs.getString(3));
			repair.setWritime(rs.getDate(4));
			repair.setReptime(rs.getDate(5));
			repair.setRepair(rs.getBoolean(6));
			repair.setReptext(rs.getString(7));
			list.add(repair);
		}
		
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0 ;
		String sql ="SELECT COUNT(repno) FROM repairs WHERE dorno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}

}
