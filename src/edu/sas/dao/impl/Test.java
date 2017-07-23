package edu.sas.dao.impl;

import edu.sas.factory.DAOFactory;
import edu.sas.vo.Dormitory;

public class Test {

	public static void main(String[] args) {
		try {
			Dormitory dor = new Dormitory();
			dor.setDorno("X1-101");
			dor.setApartno("X1");
			dor.setStutotnum(4);
			dor.setStulivnum(0);
			dor.setStuno(null);
			
			if(DAOFactory.getIDormitoryDAOInstance().doCreate(dor)){
				System.out.println(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
