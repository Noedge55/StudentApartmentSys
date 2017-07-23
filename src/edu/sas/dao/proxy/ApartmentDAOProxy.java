package edu.sas.dao.proxy;

import java.util.List;

import edu.sas.dao.IApartmentDAO;
import edu.sas.dao.impl.ApartmentDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Apartment;

public class ApartmentDAOProxy implements IApartmentDAO {
	private DatabaseConnection dbc = null;
	private IApartmentDAO dao = null;
	public ApartmentDAOProxy() {
		this.dbc = new DatabaseConnection();
		this.dao = new ApartmentDAOImpl(this.dbc.getConnection()); 
	}
	@Override
	public boolean doCreate(Apartment vo) throws Exception {
		boolean flag = false;
		try{
			if(this.dao.findById(vo.getApartno()) == null){
				flag = this.dao.doCreate(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Apartment vo) throws Exception {
		boolean flag = false ;
		try{
			flag = this.dao.doUpdate(vo);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		boolean flag = false ;
		try{
			flag = this.dao.doRemove(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag ;
	}

	@Override
	public Apartment findById(String id) throws Exception {
		Apartment apartment = null;
		try{
			apartment = this.dao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return apartment;
	}

	@Override
	public List<Apartment> findAll(String keyword) throws Exception {
		List<Apartment> list = null;
		try{
			list = this.dao.findAll(keyword);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return list;
	}

	@Override
	public int getAllCount(String keyword) throws Exception {
		int count = 0 ;
		try{
			count = this.dao.getAllCount(keyword);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return count;
	}

}
