package edu.sas.dao.proxy;

import java.util.List;

import edu.sas.dao.IRepairsDAO;
import edu.sas.dao.impl.RepairsDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Repairs;

public class RepairsDAOProxy implements IRepairsDAO {
	private DatabaseConnection dbc = null;
	private IRepairsDAO dao = null;
	public RepairsDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.dao = new RepairsDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Repairs vo) throws Exception{
		boolean flag = false;
		try{
			if(this.dao.findById(vo.getRepno()) == null){
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
	public boolean doUpdate(Repairs vo) throws Exception {
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
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return flag ;
	}

	@Override
	public Repairs findById(String id) throws Exception {
		Repairs repair = null;
		try{
			repair = this.dao.findById(id);
		}catch (Exception e) {
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return repair;
	}

	@Override
	public List<Repairs> findAll(String keyword) throws Exception {
		List<Repairs> list = null;
		try{
			list = this.dao.findAll(keyword);
		}catch(Exception e){
			e.printStackTrace() ;
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
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return count;
	}

}
