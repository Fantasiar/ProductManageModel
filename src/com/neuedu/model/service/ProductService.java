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
		//根据供应商名称获取供应商对象
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.getSupplierByName(supplier_name);
	}

	public void addProduct(Product product, int operator_id) {
		//添加新商品
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		ProductDao dao=new ProductDaoImp(conn);
		dao.addProduct(product,operator_id);
		DBUtils.commit(conn);
	}

	public List<Product> searchProductByFc(int fc_id, int pageNum) {
		//根据一级分类id分页查询下属商品
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchProductByFc(fc_id,pageNum);
	}

	public int searchFcProPageCount(int fc_id) {
		//查询一级分类下属商品列表的页数
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchFcProPageCount(fc_id);
	}

	public Product searchProductInfo(int product_id) {
		//根据商品id查询商品详细信息
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchProductInfo(product_id);
	}

	public String searchSupNameById(int supplier_id) {
		//根据供应商id查询供应商名称
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchSupNameById(supplier_id);
	}

	public List<Product> searchProductBySc(int sc_id, int pageNum) {
		//分页查询二级分类下属商品
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchProductBySc(sc_id,pageNum);
	}

	public int searchScProPageCount(int sc_id) {
		//查询二级分类下属商品列表的页数
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchScProPageCount(sc_id);
	}

	public List<Product> findAllPageProduct(int pageNum) {
		//分页查询所有的商品
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.findAllPageProduct(pageNum);
	}

	public int findAllPageCount() {
		//查询所有商品列表的页数
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.findAllPageCount();
	}

	public List<Product> findProductByName(int product_id, int pageNum) {
		//根据商品id查询所有的商品
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.findProductByName(product_id,pageNum);
	}

	public int findProductPageCount(int product_id) {
		//查询根据商品id获取的商品列表的页数
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.findProductPageCount(product_id);
	}

	public void updateProduct(Product product, int operator_id) {
		//修改商品信息
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		ProductDao dao=new ProductDaoImp(conn);
		dao.updateProduct(product,operator_id);
		DBUtils.commit(conn);
	}

	public void deleteProduct(int[] ids, int operator_id) {
		//删除商品
		Connection conn=DBUtils.getConn();
		DBUtils.beginTrasaction(conn);
		ProductDao dao=new ProductDaoImp(conn);
		dao.deleteProduct(ids,operator_id);
		DBUtils.commit(conn);
	}

	public int searchProductIdByName(String product_name) {
		//根据商品名称查询商品id
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		return dao.searchProductIdByName(product_name);
	}

	public boolean checkProductName(String product_name) {
		//校验商品名称是否重复
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		int isExist=dao.checkProductName(product_name);
		return isExist>0?true:false;
	}

	public boolean searchProCountOfSc(int sc_id) {
		//校验二级分类是否可以删除
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		int isDelete=dao.searchProCountOfSc(sc_id);
		return isDelete==0?true:false;
	}

	public boolean checkProDelete(int pro_id) {
		//校验商品是否可以被删除
		Connection conn=DBUtils.getConn();
		ProductDao dao=new ProductDaoImp(conn);
		int isDelete=dao.checkProDelete(pro_id);
		return isDelete==0?true:false;
	}
	
	
}
