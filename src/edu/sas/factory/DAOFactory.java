package edu.sas.factory;

import edu.sas.dao.IApartmentDAO;
import edu.sas.dao.ICostDAO;
import edu.sas.dao.IDormitoryDAO;
import edu.sas.dao.IDorsupDAO;
import edu.sas.dao.IHygieneDAO;
import edu.sas.dao.ILivingDAO;
import edu.sas.dao.IRepairsDAO;
import edu.sas.dao.IStudentDAO;
import edu.sas.dao.IUsersDAO;
import edu.sas.dao.proxy.ApartmentDAOProxy;
import edu.sas.dao.proxy.CostDAOProxy;
import edu.sas.dao.proxy.DormitotyDAOProxy;
import edu.sas.dao.proxy.DorsupDAOProxy;
import edu.sas.dao.proxy.HygieneDAOProxy;
import edu.sas.dao.proxy.LivingDAOProxy;
import edu.sas.dao.proxy.RepairsDAOProxy;
import edu.sas.dao.proxy.StudentDAOProxy;
import edu.sas.dao.proxy.UsersDAOProxy;

public class DAOFactory {
	public static IApartmentDAO getIApartmentDAOInstance() {
		return new ApartmentDAOProxy();
	}
	public static ICostDAO getICostDAOInstance() {
		return new CostDAOProxy();
	}
	public static IDormitoryDAO getIDormitoryDAOInstance() {
		return new DormitotyDAOProxy();
	}
	public static IDorsupDAO getIDorsupDAOInstance() {
		return new DorsupDAOProxy();
	}
	public static IHygieneDAO getIHygieneDAOInstance(){
		return new HygieneDAOProxy();
	}
	public static IRepairsDAO getIRepairsDAOInstance(){
		return new RepairsDAOProxy();
	}
	public static IStudentDAO getIStudentDAOInstance() {
		return new StudentDAOProxy();
	}
	public static IUsersDAO getIUsersDAOInstance() {
		return new UsersDAOProxy();
	}
	public static ILivingDAO getILivingDAOInstance(){
		return new LivingDAOProxy();
	}
}
