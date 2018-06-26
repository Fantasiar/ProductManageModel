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
		//���һ������
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.addFirstCategory(fc,operator_id);
		DBUtils.commit(conn);
	}

	public List<FirstCategory> searchPageFc(int pageNum) {
		//��ҳ��ѯһ�������б�
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchPageFc(pageNum);
	}

	public int searchFcPageCount() {
		//��ѯһ������ҳ��
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchFcPageCount();
	}

	public FirstCategory getFirstCategoryById(int fc_id) {
		//ͨ��һ������id��ѯһ������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getFirstCategoryById(fc_id);
	}

	public void updateFirstCategory(FirstCategory fc,int operator_id) {
		//�޸�һ������
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.updateFirstCategory(fc,operator_id);
		DBUtils.commit(conn);
	}

	public void deleteFirstCategory(int[] ids, int operator_id) {
		//ɾ��һ������
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.deleteFirstCategory(ids,operator_id);
		DBUtils.commit(conn);
	}

	public List<FirstCategory> searchAllFc() {
		//��ѯ����һ�����ࣨ����ҳ��
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchAllFc();
	}

	public FirstCategory getFirstCategoryByName(String fc_name) {
		//����һ���������Ʋ�ѯһ���������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getFirstCategoryByName(fc_name);
	}

	public void addSecondCategory(SecondCategory sc, int operator_id) {
		//��Ӷ�������
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.addSecondCategory(sc,operator_id);
		DBUtils.commit(conn);
	}

	public List<SecondCategory> searchPageSc(int pageNum) {
		//��ҳ��ѯ��������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchPageSc(pageNum);
	}

	public int searchScPageCount() {
		//��ѯ���������б�ҳ��
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchScPageCount();
	}

	public SecondCategory getSecondCategoryById(int sc_id) {
		//ͨ��id��ѯ��������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getSecondCategoryById(sc_id);
	}

	public void updateSecondCategory(SecondCategory sc, int operator_id) {
		//�޸Ķ�������
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.updateSecondCategory(sc,operator_id);
		DBUtils.commit(conn);
	}

	public void deleteSecondCategory(int[] ids, int operator_id) {
		//ɾ����������
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		CategoryDao dao=new CategoryDaoImp(conn);
		dao.deleteSecondCategory(ids,operator_id);
		DBUtils.commit(conn);
	}

	public List<SecondCategory> searchScByFcId(int fc_id) {
		//ͨ��һ������id��ѯ�����Ķ�������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchScByFcId(fc_id);
	}

	public List<Supplier> searchAllSup() {
		//��ѯ���еĹ�Ӧ��
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchAllSup();
	}

	public SecondCategory getSecondCategoryByName(String sc_name) {
		//ͨ�������������ƻ�ȡ�����������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.getSecondCategoryByName(sc_name);
	}

	public String searchFcNameById(int fc_id) {
		//ͨ��һ������id��ѯһ�����������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchFcNameById(fc_id);
	}

	public String searchScNameById(int sc_id) {
		//ͨ����������id��ѯ����������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		return dao.searchScNameById(sc_id);
	}

	public boolean checkFcName(String fc_name) {
		//У��һ��������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		int isExist=dao.checkFcName(fc_name);
		return isExist>0?true:false;
	}

	public boolean checkScName(String sc_name) {
		//У�����������
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		int isExist=dao.checkScName(sc_name);
		return isExist>0?true:false;
	}

	public boolean getCountOfScInFc(int fc_id) {
		//У��һ�������Ƿ���Ա�ɾ��
		Connection conn=DBUtils.getConn();
		CategoryDao dao=new CategoryDaoImp(conn);
		int isDelete=dao.getCountOfScInFc(fc_id);
		return isDelete==0?true:false;
	}
}
