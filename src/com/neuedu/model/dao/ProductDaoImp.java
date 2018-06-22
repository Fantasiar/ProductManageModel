package com.neuedu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.Product;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.po.Supplier;
import com.neuedu.utils.DBUtils;

public class ProductDaoImp implements ProductDao{
	private Connection conn;
	
	public ProductDaoImp(Connection conn) {
		this.conn=conn;
	}

	@Override
	public Supplier getSupplierByName(String supplier_name) {
		// TODO Auto-generated method stub
		Supplier sup=new Supplier();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select * from supplier where supplier_name=? ");
			ps.setString(1, supplier_name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sup.setSupplier_id(rs.getInt("supplier_id"));
				sup.setSupplier_name(rs.getString("supplier_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sup;
	}

	@Override
	public void addProduct(Product product, int operator_id) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		int status=1;
		Date operator_date=new Date();
		try {
			ps=conn.prepareStatement("insert into product"
					+ " values(seq_pro.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, product.getProduct_name());
			ps.setInt(2, product.getFc().getFc_id());
			ps.setInt(3, product.getSc().getSc_id());
			ps.setString(4, product.getMeasure());
			ps.setDouble(5, product.getOriginal_price());
			ps.setDouble(6, product.getDiscount());
			ps.setDouble(7, product.getCost_price());
			ps.setString(8, product.getVersion());
			ps.setInt(9, product.getSupplier().getSupplier_id());
			ps.setString(10, product.getPublisher());
			ps.setString(11, product.getShelf_life());
			ps.setString(12, product.getRemarks());
			ps.setInt(13, status);
			ps.setInt(14, operator_id);
			ps.setDate(15, new java.sql.Date(operator_date.getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closePS(ps);
		}
	}

	@Override
	public List<Product> searchProductByFc(int fc_id, int pageNum) {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		PreparedStatement ps=null;
		int pageSize=6;
		StringBuffer sbf=new StringBuffer("");
		sbf.append("select * from product where status=1 and fc_id="+fc_id);
		try {
			ps=conn.prepareStatement(" select b.* from ( "
					+ " select a.*,rownum rw from ( "
					+ sbf.toString() +  "  ) a "
					+ " where rownum<= "+ (pageSize*pageNum) +" ) b  "
					+ " where rw>"+ pageSize*(pageNum-1));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int searchFcProPageCount(int fc_id) {
		// TODO Auto-generated method stub
		int count=0;
		int pageSize=6;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select count(*) c from product where status=1 and fc_id="+fc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pagecount = 0;
		if(count%pageSize==0){
			pagecount = count/pageSize;
		}else{
			pagecount = count/pageSize+1;
		}
		return pagecount;
	}

	@Override
	public Product searchProductInfo(int product_id) {
		// TODO Auto-generated method stub
		Product product=new Product();
		FirstCategory fc=new FirstCategory();
		SecondCategory sc=new SecondCategory();
		Supplier sup=new Supplier();
		PreparedStatement ps=null;
		try {
//			ps=conn.prepareStatement("select p.product_name,p.fc_id,p.sc_id,"
//					+ "f.fc_name,s.sc_name, "
//					+ "p.measure,p.original_price,p.discount,p.cost_price, "
//					+ "p.version,sup.supplier_id,p.publisher,p.shelf_life, "
//					+ "p.remarks from product p,firstcategory f,secondcategory s, "
//					+ "supplier sup where p.supplier_id=sup.supplier_id and "
//					+ "p.fc_id=f.fc_id and f.fc_id=s.fc_id and p.sc_id=s.sc_id and "
//					+ "p.product_id="+product_id);
			ps=conn.prepareStatement("select * from product where product_id="+product_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fc.setFc_id(rs.getInt("fc_id"));
				sc.setSc_id(rs.getInt("sc_id"));
				sup.setSupplier_id(rs.getInt("supplier_id"));
				product.setProduct_id(product_id);
				product.setProduct_name(rs.getString("product_name"));
				product.setFc(fc);
				product.setSc(sc);
				product.setMeasure(rs.getString("measure"));
				product.setOriginal_price(rs.getDouble("original_price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setCost_price(rs.getDouble("cost_price"));
				product.setVersion(rs.getString("version"));
				product.setSupplier(sup);
				product.setPublisher(rs.getString("publisher"));
				product.setShelf_life(rs.getString("shelf_life"));
				product.setRemarks(rs.getString("remarks"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public String searchSupNameById(int supplier_id) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String supplier_name="";
		try {
			ps=conn.prepareStatement("select supplier_name from supplier where supplier_id="+supplier_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				supplier_name=rs.getString("supplier_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplier_name;
	}

	@Override
	public List<Product> searchProductBySc(int sc_id, int pageNum) {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		PreparedStatement ps=null;
		int pageSize=6;
		StringBuffer sbf=new StringBuffer("");
		sbf.append("select * from product where status=1 and sc_id="+sc_id);
		try {
			ps=conn.prepareStatement(" select b.* from ( "
					+ " select a.*,rownum rw from ( "
					+ sbf.toString() +  "  ) a "
					+ " where rownum<= "+ (pageSize*pageNum) +" ) b  "
					+ " where rw>"+ pageSize*(pageNum-1));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int searchScProPageCount(int sc_id) {
		// TODO Auto-generated method stub
		int count=0;
		int pageSize=6;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select count(*) c from product where status=1 and sc_id="+sc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pagecount = 0;
		if(count%pageSize==0){
			pagecount = count/pageSize;
		}else{
			pagecount = count/pageSize+1;
		}
		return pagecount;
	}
	
}
