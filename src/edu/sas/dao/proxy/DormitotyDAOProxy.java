package edu.sas.dao.proxy;

import java.util.List;

import edu.sas.dao.IDormitoryDAO;
import edu.sas.dao.impl.DormitoryDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Dormitory;

public class DormitotyDAOProxy implements IDormitoryDAO {
	private DatabaseConnection dbc = null;
	private IDormitoryDAO dao = null;
	public DormitotyDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.dao = new DormitoryDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Dormitory vo) throws Exception {
		boolean flag = false;
		try{
			if(this.dao.findById(vo.getDorno()) == null){
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
	public boolean doUpdate(Dormitory vo) throws Exception {
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
	public Dormitory findById(String id) throws Exception {
		Dormitory dormitory = null;
		try{
			dormitory = this.dao.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return dormitory;
	}

	@Override
	public List<Dormitory> findAll(String keyword) throws Exception {
		List<Dormitory> list = null;
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
	@Override
	public List<Dormitory> findAllPaging(String keyword, int pageNow, int pageSize) throws Exception {
		List<Dormitory> list = null;
		try{
			list = this.dao.findAllPaging(keyword, pageNow, pageSize);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.dbc.close();
		}
		return list;
	}

}
