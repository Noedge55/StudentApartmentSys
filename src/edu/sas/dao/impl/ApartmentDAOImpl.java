package edu.sas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.sas.dao.IApartmentDAO;
import edu.sas.factory.DAOFactory;
import edu.sas.vo.Apartment;
import edu.sas.vo.Dormitory;

public class ApartmentDAOImpl implements IApartmentDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null ;
	public ApartmentDAOImpl(Connection conn) {
		this.conn = conn ;
	}
	@Override
	public boolean doCreate(Apartment vo) throws Exception {
		boolean flag = false ;
		String sql = "INSERT INTO apartment(apartno,lvdornum,stulivnum,stutotnum,area,levels) values (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getApartno());
		this.pstmt.setInt(2, vo.getLvdornum());
		this.pstmt.setInt(3, vo.getStulivnum());
		this.pstmt.setInt(4, vo.getStutotnum());
		this.pstmt.setFloat(5, vo.getArea());
		this.pstmt.setInt(6, vo.getLevels());
		//���²���
		if(this.pstmt.executeUpdate() > 0){
			String apartno = vo.getApartno();
			int lvdornum = vo.getLvdornum();
			int levels = vo.getLevels();
			//�ڹ�Ԣ�������֮�󣬽���Ԣ�ڲ����������ҽ������
			for(int i = 1 ; i <= levels ; i ++){
				for(int j = 1 ; j <= lvdornum ; j++){
					 
					Dormitory dor = new Dormitory();
					//���ҺŸ�ʽΪ��"��Ԣ��+'-'+¥��+���
					dor.setDorno(apartno + "-" + i +(j<10?("0"+j):j));
					dor.setApartno(apartno);
					dor.setStutotnum(4);
					dor.setStulivnum(0);
					//�½����ҵ�ʱ�����ҳ�����������Ϊ��
					dor.setStuno(null);
					DAOFactory.getIDormitoryDAOInstance().doCreate(dor) ;
				}
			}
			
			flag = true;
		}
		return flag ;
	}

	@Override
	public boolean doUpdate(Apartment vo) throws Exception {
		boolean flag = false ;
		String sql = "update apartment SET lvdornum=?,stulivnum=?,stutotnum=?,area=?,levels=? WHERE apartno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getLvdornum());
		this.pstmt.setInt(2, vo.getStulivnum());
		this.pstmt.setInt(3, vo.getStutotnum());
		this.pstmt.setFloat(4, vo.getArea());
		this.pstmt.setString(5, vo.getApartno());
		this.pstmt.setInt(6, vo.getLevels());
		if(this.pstmt.executeUpdate() > 0){
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false ;
		//��Ԣɾ��֮ǰ����Ԣ������Ҳ����ɾ��
		Apartment apart = DAOFactory.getIApartmentDAOInstance().findById(id);
		for(int i = 1 ; i <= apart.getLevels() ; i ++){
			for(int j = 1 ; j <= apart.getLvdornum() ; j++){
				DAOFactory.getIDormitoryDAOInstance().doRemove(apart.getApartno() + "-" + i +(j<10?("0"+j):j));
			}
		}
		String sql = "DELETE FROM apartment where apartno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if(this.pstmt.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}

	@Override
	public Apartment findById(String id) throws Exception {
		Apartment apartment = null ;
		String sql = "select apartno,lvdornum,stutotnum,stulivnum,area,levels from apartment where apartno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			apartment = new Apartment();
			apartment.setApartno(rs.getString(1));
			apartment.setLvdornum(rs.getInt(2));;
			apartment.setStutotnum(rs.getInt(3));
			apartment.setStulivnum(rs.getInt(4));
			apartment.setArea(rs.getFloat(5));
			apartment.setLevels(rs.getInt(6));
		}
		return apartment;
	}

	@Override
	public List<Apartment> findAll(String keyword) throws Exception {
		List<Apartment> list = new ArrayList<>();
		String sql = "select apartno,lvdornum,stutotnum,stulivnum,area,levels from apartment where apartno LIKE ?";
		
		//String sql = "select apartno,dornum,stutotnum,stulivnum,area from apartment where 1=1 ";
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		
		while(rs.next()){
			Apartment apartment = new Apartment();
			apartment.setApartno(rs.getString(1));
			apartment.setLvdornum(rs.getInt(2));
			apartment.setStutotnum(rs.getInt(3));
			apartment.setStulivnum(rs.getInt(4));
			apartment.setArea(rs.getFloat(5));
			apartment.setLevels(rs.getInt(6));
			list.add(apartment);
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0;
		String sql = "select count(apartno) from apartment WHERE apartno LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyword + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count;
	}
}
