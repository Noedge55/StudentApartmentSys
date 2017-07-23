package edu.sas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.IStudentDAO;
import edu.sas.vo.Student;

public class StudentDAOImpl implements IStudentDAO {
	private Connection conn =null;
	private PreparedStatement pstmt = null;
	public StudentDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Student vo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO student(stuno,stuname,sex,major,classname,phonenum) VALUES (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getStuno());
		this.pstmt.setString(2, vo.getStuname());
		this.pstmt.setInt(3, vo.getSex());
		this.pstmt.setString(4, vo.getMajor());
		this.pstmt.setString(5, vo.getClassname());
		this.pstmt.setString(6, vo.getPhonenum());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag ;
	}

	@Override
	public boolean doUpdate(Student vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE student SET stuname=?,sex=?,major=?,classname=?,phonenum=? WHERE stuno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getStuname());
		this.pstmt.setInt(2, vo.getSex());
		this.pstmt.setString(3, vo.getMajor());
		this.pstmt.setString(4, vo.getClassname());
		this.pstmt.setString(5, vo.getPhonenum());
		this.pstmt.setString(6, vo.getStuno());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag ;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM student WHERE stuno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag ;
	}

	@Override
	public Student findById(String id) throws Exception {
		Student student = null;
		String sql = "SELECT stuno,stuname,sex,major,classname,phonenum FROM student WHERE stuno = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			student = new Student();
			student.setStuno(rs.getString(1));
			student.setStuname(rs.getString(2));
			student.setSex(rs.getInt(3));
			student.setMajor(rs.getString(4));
			student.setClassname(rs.getString(5));
			student.setPhonenum(rs.getString(6));
		}
		return student;
	}

	@Override
	public List<Student> findAll(String keyword) throws Exception {
		List<Student> list = new ArrayList<>();
		String sql = "SELECT stuno,stuname,sex,major,classname,phonenum FROM student WHERE stuno LIKE ? OR classname LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		this.pstmt.setString(2, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Student student = new Student();
			student.setStuno(rs.getString(1));
			student.setStuname(rs.getString(2));
			student.setSex(rs.getInt(3));
			student.setMajor(rs.getString(4));
			student.setClassname(rs.getString(5));
			student.setPhonenum(rs.getString(6));
			list.add(student);
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0;
		String sql = "SELECT COUNT(stuno) WHERE stuno LIKE ? OR classname LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
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
