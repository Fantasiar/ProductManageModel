package com.neuedu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
		//根据供应商名称获取供应商对象
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
		//添加新商品
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
		//根据一级分类id分页查询下属商品
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
		//查询一级分类下属商品列表的页数
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
		//根据商品id查询商品详细信息
		Product product=new Product();
		FirstCategory fc=new FirstCategory();
		SecondCategory sc=new SecondCategory();
		Supplier sup=new Supplier();
		PreparedStatement ps=null;
		try {
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
		//根据供应商id查询供应商名称
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
		//分页查询二级分类下属商品
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
		//查询二级分类下属商品列表的页数
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

	@Override
	public List<Product> findAllPageProduct(int pageNum) {
		//分页查询所有的商品
		List<Product> list=new ArrayList<Product>();
		PreparedStatement ps=null;
		int pageSize=6;
		StringBuffer sbf=new StringBuffer("");
		sbf.append("select * from product where status=1");
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
	public int findAllPageCount() {
		//查询所有商品列表的页数
		int count=0;
		int pageSize=6;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select count(*) c from product where status=1");
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
	public List<Product> findProductByName(int product_id, int pageNum) {
		//根据商品id查询所有的商品
		List<Product> list=new ArrayList<Product>();
		PreparedStatement ps=null;
		int pageSize=3;
		StringBuffer sbf=new StringBuffer("");
		sbf.append("select * from product where status=1 and product_id=?");
		try {
			ps=conn.prepareStatement(" select b.* from ( "
					+ " select a.*,rownum rw from ( "
					+ sbf.toString() +  "  ) a "
					+ " where rownum<= "+ (pageSize*pageNum) +" ) b  "
					+ " where rw>"+ pageSize*(pageNum-1));
			ps.setInt(1, product_id);
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
	public int findProductPageCount(int product_id) {
		//查询根据商品id获取的商品列表的页数
		int count=0;
		int pageSize=3;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select count(*) c from product where status=1 and product_id=?");
			ps.setInt(1, product_id);
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
	public void updateProduct(Product product, int operator_id) {
		//修改商品信息
		PreparedStatement ps=null;
		Date operator_date = new Date();
		try {
			ps=conn.prepareStatement("update product set product_name=? , fc_id=? , sc_id=? , measure=? , original_price=? , discount=? , cost_price=? , version=? , supplier_id=? , publisher=? , shelf_life=? , remarks=? , operator_id=? , operator_date=? where product_id=? ");
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
			ps.setInt(13, operator_id);
			ps.setDate(14, new java.sql.Date(operator_date.getTime()));
			ps.setInt(15, product.getProduct_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closePS(ps);
		}
	}

	@Override
	public void deleteProduct(int[] ids, int operator_id) {
		//删除商品
		String id=Arrays.toString(ids).replace('[','(').replace(']',')');
		PreparedStatement ps=null;
		Date operator_date = new Date();
		try {
			ps=conn.prepareStatement("update product set status=0,operator_id=?,operator_date=?"+
			" where product_id in "+id);
			ps.setInt(1, operator_id);
			ps.setDate(2, new java.sql.Date(operator_date.getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closePS(ps);
		}
	}

	@Override
	public int searchProductIdByName(String product_name) {
		//根据商品名称查询商品id
		int product_id=0;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select product_id from product where product_name=? ");
			ps.setString(1, product_name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product_id=rs.getInt("product_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product_id;
	}

	@Override
	public int checkProductName(String product_name) {
		//校验商品名称是否重复
		PreparedStatement ps=null;
		int count=0;
		try {
			ps=conn.prepareStatement("select count(*) c from product where product_name=?");
			ps.setString(1, product_name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int searchProCountOfSc(int sc_id) {
		//校验二级分类是否可以删除
		PreparedStatement ps=null;
		int count=0;
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
		return count;
	}

	@Override
	public int checkProDelete(int pro_id) {
		//校验商品是否可以被删除
		PreparedStatement ps=null;
		int count=0;
		try {
			ps=conn.prepareStatement("select count(*) c from orderinfo where status in (1,2,3,4,5,6,7) and product_id="+pro_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}
