package edu.sas.dao;

import java.util.List;

import edu.sas.vo.Living;

public interface ILivingDAO extends IDAO<Living, String> {
	public List<Living> findAllPaging(String keyword,int pageNow,int pageSize) throws Exception;
}
