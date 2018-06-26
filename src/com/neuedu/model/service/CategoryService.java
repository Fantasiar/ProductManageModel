package com.neuedu.model.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.model.dao.CategoryDao;
import com.neuedu.model.dao.CategoryDaoImp;
import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.po.Supplier;
import com.neuedu.utils.DBUtils;

public class CategoryService {
	private CategoryService() {};
	
	private static CategoryService service=new CategoryService();
	
	public static CategoryService getInstance() {
		return service;
	}

	public void addFirstCategory(FirstCategory fc, int operator_id) {
		//添加一级分类
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.addFirstCategory(fc,operator_id);
		DBUtils.commit(conn);
	}

	public List<FirstCategory> searchPageFc(int pageNum) {
		//分页查询一级分类列表
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchPageFc(pageNum);
	}

	public int searchFcPageCount() {
		//查询一级分类页数
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchFcPageCount();
	}

	public FirstCategory getFirstCategoryById(int fc_id) {
		//通过一级分类id查询一级分类
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getFirstCategoryById(fc_id);
	}

	public void updateFirstCategory(FirstCategory fc,int operator_id) {
		//修改一级分类
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.updateFirstCategory(fc,operator_id);
		DBUtils.commit(conn);
	}

	public void deleteFirstCategory(int[] ids, int operator_id) {
		//删除一级分类
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.deleteFirstCategory(ids,operator_id);
		DBUtils.commit(conn);
	}

	public List<FirstCategory> searchAllFc() {
		//查询所有一级分类（不分页）
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchAllFc();
	}

	public FirstCategory getFirstCategoryByName(String fc_name) {
		//根据一级分类名称查询一级分类对象
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getFirstCategoryByName(fc_name);
	}

	public void addSecondCategory(SecondCategory sc, int operator_id) {
		//添加二级分类
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.addSecondCategory(sc,operator_id);
		DBUtils.commit(conn);
	}

	public List<SecondCategory> searchPageSc(int pageNum) {
		//分页查询二级分类
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchPageSc(pageNum);
	}

	public int searchScPageCount() {
		//查询二级分类列表页数
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchScPageCount();
	}

	public SecondCategory getSecondCategoryById(int sc_id) {
		//通过id查询二级分类
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getSecondCategoryById(sc_id);
	}

	public void updateSecondCategory(SecondCategory sc, int operator_id) {
		//修改二级分类
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.updateSecondCategory(sc,operator_id);
		DBUtils.commit(conn);
	}

	public void deleteSecondCategory(int[] ids, int operator_id) {
		//删除二级分类
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.deleteSecondCategory(ids,operator_id);
		DBUtils.commit(conn);
	}

	public List<SecondCategory> searchScByFcId(int fc_id) {
		//通过一级分类id查询下属的二级分类
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchScByFcId(fc_id);
	}

	public List<Supplier> searchAllSup() {
		//查询所有的供应商
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchAllSup();
	}

	public SecondCategory getSecondCategoryByName(String sc_name) {
		//通过二级分类名称获取二级分类对象
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getSecondCategoryByName(sc_name);
	}

	public String searchFcNameById(int fc_id) {
		//通过一级分类id查询一级分类的名称
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchFcNameById(fc_id);
	}

	public String searchScNameById(int sc_id) {
		//通过二级分类id查询二级分类名
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchScNameById(sc_id);
	}

	public boolean checkFcName(String fc_name) {
		//校验一级分类名
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		int isExist=dao.checkFcName(fc_name);
		return isExist>0?true:false;
	}

	public boolean checkScName(String sc_name) {
		//校验二级分类名
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		int isExist=dao.checkScName(sc_name);
		return isExist>0?true:false;
	}

	public boolean getCountOfScInFc(int fc_id) {
		//校验一级分类是否可以被删除
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		int isDelete=dao.getCountOfScInFc(fc_id);
		return isDelete==0?true:false;
	}
}
