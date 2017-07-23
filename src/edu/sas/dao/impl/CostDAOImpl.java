package edu.sas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.ICostDAO;
import edu.sas.vo.Cost;
/**
 * 收支明细表操作实现类
 * @author Noedge
 *
 */
public class CostDAOImpl implements ICostDAO{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public CostDAOImpl(Connection conn) {
		this.conn = conn;
	}
	//创建费用明细表
	@Override
	public boolean doCreate(Cost vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO cost(costno,dorno,rctype,rcmoney,rctime,used,remain,totmoney) values(?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getCostno());
		this.pstmt.setString(2, vo.getDorno());
		this.pstmt.setInt(3, vo.getRctype());
		this.pstmt.setInt(4, vo.getRcmoney());
		this.pstmt.setDate(5, new java.sql.Date(vo.getRctime().getTime()));
		this.pstmt.setInt(6, vo.getUsed());
		this.pstmt.setInt(7, vo.getRemain());
		this.pstmt.setInt(7, vo.getTotmoney());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Cost vo) throws Exception {
		//该方法不需要
		return false;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		//该方法不需要
		return false;
	}

	@Override
	public Cost findById(String id) throws Exception {
		Cost cost = null;
		String sql = "SELECT costno,dorno,rctype,rcmoney,rctime,used,remain,totmoney FROM cost WHERE costno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			cost = new Cost();
			cost.setCostno(rs.getString(1));
			cost.setDorno(rs.getString(2));
			cost.setRctype(rs.getInt(3));
			cost.setRcmoney(rs.getInt(4));
			cost.setRctime(rs.getDate(5));
			cost.setUsed(rs.getInt(6));
			cost.setRemain(rs.getInt(7));
			cost.setTotmoney(rs.getInt(8));
		}
		return cost;
	}

	@Override
	public List<Cost> findAll(String keyword) throws Exception {
		List<Cost> list = new ArrayList<>();
		String sql = "SELECT costno,dorno,rctype,rcmoney,rctime,used,remain,totmoney FROM cost WHERE dorno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, keyword);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Cost cost = new Cost();
			cost.setCostno(rs.getString(1));
			cost.setDorno(rs.getString(2));
			cost.setRctype(rs.getInt(3));
			cost.setRcmoney(rs.getInt(4));
			cost.setRctime(rs.getDate(5));
			cost.setUsed(rs.getInt(6));
			cost.setRemain(rs.getInt(7));
			cost.setTotmoney(rs.getInt(8));
			list.add(cost);
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0;
		String sql = "SELECT COUNT(costno) FROM cost WHERE dorno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, keyword);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
}
