package com.neuedu.model.dao;

import java.util.List;

import com.neuedu.model.po.Product;
import com.neuedu.model.po.Supplier;

public interface ProductDao {

	Supplier getSupplierByName(String supplier_name);

	void addProduct(Product product, int operator_id);

	List<Product> searchProductByFc(int fc_id, int pageNum);

	int searchFcProPageCount(int fc_id);

	Product searchProductInfo(int product_id);

	String searchSupNameById(int supplier_id);

	List<Product> searchProductBySc(int sc_id, int pageNum);

	int searchScProPageCount(int sc_id);

	List<Product> findAllPageProduct(int pageNum);

	int findAllPageCount();

	List<Product> findProductByName(int product_id, int pageNum);

	int findProductPageCount(int product_id);

	void updateProduct(Product product, int operator_id);

	void deleteProduct(int[] ids, int operator_id);

	int searchProductIdByName(String product_name);

	int checkProductName(String product_name);

}
