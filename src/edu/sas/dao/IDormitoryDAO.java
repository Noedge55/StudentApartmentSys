package edu.sas.dao;

import java.util.List;

import edu.sas.vo.Dormitory;

public interface IDormitoryDAO extends IDAO<Dormitory, String> {
	public List<Dormitory> findAllPaging(String keyword,int pageNow,int pageSize) throws Exception;
}
