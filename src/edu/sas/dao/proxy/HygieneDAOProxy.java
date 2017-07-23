package edu.sas.dao.proxy;

import java.util.List;

import edu.sas.dao.IHygieneDAO;
import edu.sas.dao.impl.HygieneDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Hygiene;

public class HygieneDAOProxy implements IHygieneDAO {
	private DatabaseConnection dbc = null;
	private IHygieneDAO dao = null;
	public HygieneDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.dao = new HygieneDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Hygiene vo) throws Exception {
		boolean flag = false;
		try{
			if(this.dao.findById(vo.getHygno()) == null){
				flag = this.doCreate(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Hygiene vo) throws Exception {
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
	public Hygiene findById(String id) throws Exception {
		Hygiene hygiene = null;
		try{
			hygiene = this.dao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return hygiene;
	}

	@Override
	public List<Hygiene> findAll(String keyword) throws Exception {
		List<Hygiene> list = null;
		try{
			list = this.dao.findAll(keyword);
		}catch(Exception e){
			e.printStackTrace();
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
