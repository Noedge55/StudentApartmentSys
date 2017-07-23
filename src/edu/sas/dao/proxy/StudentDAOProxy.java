package edu.sas.dao.proxy;

import java.util.List;

import edu.sas.dao.IStudentDAO;
import edu.sas.dao.impl.StudentDAOImpl;
import edu.sas.dbc.DatabaseConnection;
import edu.sas.vo.Student;

public class StudentDAOProxy implements IStudentDAO {
	private DatabaseConnection dbc = null;
	private IStudentDAO dao = null;
	public StudentDAOProxy(){
		this.dbc = new DatabaseConnection();
		this.dao = new StudentDAOImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Student vo) throws Exception {
		boolean flag = false;
		try{
			if(this.dao.findById(vo.getStuno()) == null){
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
	public boolean doUpdate(Student vo) throws Exception {
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
	public Student findById(String id) throws Exception {
		Student student = null;
		try{
			student = this.dao.findById(id);
		}catch (Exception e) {
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return student;
	}

	@Override
	public List<Student> findAll(String keyword) throws Exception {
		List<Student> list = null;
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
			e.printStackTrace() ;
		}finally{
			this.dbc.close();
		}
		return count;
	}

}
