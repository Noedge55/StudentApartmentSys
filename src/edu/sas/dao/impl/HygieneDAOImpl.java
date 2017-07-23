package edu.sas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.IHygieneDAO;
import edu.sas.vo.Hygiene;
/**
 * 卫生信息表操作实现类
 * @author Noedge
 *
 */
public class HygieneDAOImpl implements IHygieneDAO {
	private Connection conn =null;
	private PreparedStatement pstmt = null;
	public HygieneDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Hygiene vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO hygiene(hygno,dorno,cktime,hyscore,hytext) VALUES(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getHygno());
		this.pstmt.setString(2, vo.getDorno());
		this.pstmt.setDate(3,new java.sql.Date(vo.getCktime().getTime()));
		this.pstmt.setInt(4, vo.getHyscore());
		this.pstmt.setString(5, vo.getHytext());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Hygiene vo) throws Exception {
		boolean flag = false ;
		String sql = "UPDATE hygiene SET hyscore=?,hytext=? WHERE hygno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getHyscore());
		this.pstmt.setString(2, vo.getHytext());
		this.pstmt.setString(3, vo.getHygno());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM hygiene WHERE hygno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if(this.pstmt.executeUpdate() > 0){
			flag = true ;
		}
		return flag;
	}

	@Override
	public Hygiene findById(String id) throws Exception {
		Hygiene hygiene = null;
		String sql = "SELECT hygno,dorno,cktime,hyscore,hytext FROM hygiene WHERE hygno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			hygiene = new Hygiene();
			hygiene.setHygno(rs.getString(1));
			hygiene.setDorno(rs.getString(2));
			hygiene.setCktime(rs.getDate(3));
			hygiene.setHyscore(rs.getInt(4));
			hygiene.setHytext(rs.getString(5));
		}
		return hygiene;
	}

	@Override
	public List<Hygiene> findAll(String keyword) throws Exception {
		List<Hygiene> list = new ArrayList<>();
		String sql = "SELECT hygno,dorno,cktime,hyscore,hytext FROM hygiene WHERE dorno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Hygiene hygiene = new Hygiene();
			hygiene.setHygno(rs.getString(1));
			hygiene.setDorno(rs.getString(2));
			hygiene.setCktime(rs.getDate(3));
			hygiene.setHyscore(rs.getInt(4));
			hygiene.setHytext(rs.getString(5));
			list.add(hygiene);
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0;
		String sql = "SELECT COUNT(hygno) FROM hygiene WHERE hygno LIKE ? OR dorno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		this.pstmt.setString(2, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}

}
