package com.neuedu.model.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.model.dao.CategoryDao;
import com.neuedu.model.dao.CategoryDaoImp;
import com.neuedu.model.dao.ProductDao;
import com.neuedu.model.dao.ProductDaoImp;
import com.neuedu.model.po.Product;
import com.neuedu.model.po.Supplier;
import com.neuedu.utils.DBUtils;

public class ProductService {
	private ProductService() {};
	
	private static ProductService service=new ProductService();
	
	public static ProductService getInstance() {
		return service;
	}

	public Supplier getSupplierByName(String supplier_name) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.getSupplierByName(supplier_name);
	}

	public void addProduct(Product product, int operator_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		ProductDao dao=new ProductDaoImp(conn);
		dao.addProduct(product,operator_id);
		DBUtils.commit(conn);
	}

	public List<Product> searchProductByFc(int fc_id, int pageNum) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchProductByFc(fc_id,pageNum);
	}

	public int searchFcProPageCount(int fc_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchFcProPageCount(fc_id);
	}

	public Product searchProductInfo(int product_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchProductInfo(product_id);
	}

	public String searchSupNameById(int supplier_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchSupNameById(supplier_id);
	}

	public List<Product> searchProductBySc(int sc_id, int pageNum) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchProductBySc(sc_id,pageNum);
	}

	public int searchScProPageCount(int sc_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchScProPageCount(sc_id);
	}

	public List<Product> findAllPageProduct(int pageNum) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.findAllPageProduct(pageNum);
	}

	public int findAllPageCount() {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.findAllPageCount();
	}

	public List<Product> findProductByName(String product_name, int pageNum) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.findProductByName(product_name,pageNum);
	}

	public int findProductPageCount(String product_name) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.findProductPageCount(product_name);
	}

	public void updateProduct(Product product, int operator_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		ProductDao dao=new ProductDaoImp(conn);
		dao.updateProduct(product,operator_id);
		DBUtils.commit(conn);
	}

	public void deleteProduct(int[] ids, int operator_id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		ProductDao dao=new ProductDaoImp(conn);
		dao.deleteProduct(ids,operator_id);
		DBUtils.commit(conn);
	}
	
	
}
