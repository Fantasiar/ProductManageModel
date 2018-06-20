package com.neuedu.model.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.model.dao.CategoryDao;
import com.neuedu.model.dao.CategoryDaoImp;
import com.neuedu.model.po.FirstCategory;
import com.neuedu.utils.DBUtils;

public class CategoryService {
	private CategoryService() {};
	
	private static CategoryService service=new CategoryService();
	
	public static CategoryService getInstance() {
		return service;
	}

	public void addFirstCategory(FirstCategory fc, int operator_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.addFirstCategory(fc,operator_id);
		DBUtils.commit(conn);
		
		//	UserDao dao=new UserDaoImp(conn);
		//	dao.register(user,conn);
		//	DBUtils.commit(conn);
			
	}

	public List<FirstCategory> searchPageFc(int pageNum) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchPageFc(pageNum);
	}

	public int searchFcPageCount() {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchFcPageCount();
	}

	public FirstCategory getFirstCategoryById(int fc_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getFirstCategoryById(fc_id);
	}

	public void updateFirstCategory(FirstCategory fc,int operator_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.updateFirstCategory(fc,operator_id);
		DBUtils.commit(conn);
	}

	public void deleteFirstCategory(int[] ids, int operator_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.deleteFirstCategory(ids,operator_id);
		DBUtils.commit(conn);
	}
}