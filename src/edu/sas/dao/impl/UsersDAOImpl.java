package edu.sas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.IUsersDAO;
import edu.sas.vo.Users;

public class UsersDAOImpl implements IUsersDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public UsersDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Users vo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO users(userid,password,permission) VALUES(?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getUserid());
		this.pstmt.setString(2, vo.getPassword());
		this.pstmt.setInt(3, vo.getPermission());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag ;
	}

	@Override
	public boolean doUpdate(Users vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE users SET password=?,permission=? WHERE userid = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getPassword());
		this.pstmt.setInt(2, vo.getPermission());
		this.pstmt.setString(3, vo.getUserid());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag ;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM users WHERE userid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag ;
	}

	@Override
	public Users findById(String id) throws Exception {
		Users user = null;
		String sql = "SELECT userid,password,permission FROM users WHERE userid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			user = new Users();
			user.setUserid(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setPermission(rs.getInt(3));
		}
		return user;
	}

	@Override
	public List<Users> findAll(String keyword) throws Exception {
		List<Users> list = new ArrayList<Users>();
		String sql = "SELECT userid,password,permission FROM users WHERE userid LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Users user = new Users();
			user.setUserid(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setPermission(rs.getInt(3));
			list.add(user);
		}
		return list;
	}
	
	@Override
	public List<Users> findAll(Integer permission) throws Exception {
		List<Users> list = new ArrayList<Users>();
		String sql = "SELECT userid,password,permission FROM users WHERE permission LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, permission);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Users user = new Users();
			user.setUserid(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setPermission(rs.getInt(3));
			list.add(user);
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0;
		String sql = "SELECT COUNT(userid) FROM users WHERE userid LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
	@Override
	public int getAllCount(Integer permission) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean findLogin(String userid, String password) throws Exception {
		boolean flag = false;
		String sql = "SELECT COUNT(userid) FROM users WHERE userid=? AND password=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, userid);
		this.pstmt.setString(2, password);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			if(rs.getInt(1) > 0){
				flag = true;
			}
		}
		return flag;
	}

}
