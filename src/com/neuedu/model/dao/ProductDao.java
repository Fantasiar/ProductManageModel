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

}
