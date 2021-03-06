package com.neuedu.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.po.Supplier;
import com.neuedu.utils.DBUtils;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.org.apache.regexp.internal.recompile;

public class CategoryDaoImp implements CategoryDao{
	private Connection conn;
	
	public CategoryDaoImp(Connection conn) {
		this.conn=conn;
	}

	@Override
	public void addFirstCategory(FirstCategory fc, int operator_id) {
		//添加一级分类
		PreparedStatement ps=null;
		int status=1;
		Date operator_date=new Date();
		try {
			ps=conn.prepareStatement("insert into firstcategory values(seq_fc.nextval,?,?,?,?,?)");
			ps.setString(1, fc.getFc_name());
			ps.setString(2, fc.getFc_info());
			ps.setInt(3, status);
			ps.setInt(4, operator_id);
			ps.setDate(5, new java.sql.Date(operator_date.getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closePS(ps);
		}
		
	}

	@Override
	public List<FirstCategory> searchPageFc(int pageNum) {
		//分页查询一级分类列表
		List<FirstCategory> list=new ArrayList<FirstCategory>();
		PreparedStatement ps=null;
		int pageSize=8;
		StringBuffer sbf=new StringBuffer("");
		sbf.append("select * from firstcategory where status=1");
		try {
			ps=conn.prepareStatement(" select b.* from ( "
					+ " select a.*,rownum rw from ( "
					+ sbf.toString() +  "  ) a "
					+ " where rownum<= "+ (pageSize*pageNum) +" ) b  "
					+ " where rw>"+ pageSize*(pageNum-1));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FirstCategory fc=new FirstCategory();
				fc.setFc_id(rs.getInt("fc_id"));
				fc.setFc_name(rs.getString("fc_name"));
				fc.setFc_info(rs.getString("fc_info"));
				list.add(fc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int searchFcPageCount() {
		//查询一级分类页数
		int count=0;
		int pageSize=8;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select count(*) c from firstcategory where status=1");
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
	public FirstCategory getFirstCategoryById(int fc_id) {
		//通过一级分类id查询一级分类
		FirstCategory fc=new FirstCategory();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select * from firstcategory where fc_id="+fc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fc.setFc_id(rs.getInt("fc_id"));
				fc.setFc_name(rs.getString("fc_name"));
				fc.setFc_info(rs.getString("fc_info"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fc;
	}

	@Override
	public void updateFirstCategory(FirstCategory fc, int operator_id) {
		//修改一级分类
		PreparedStatement ps=null;
		Date operator_date = new Date();
		try {
			ps=conn.prepareStatement("update firstcategory set fc_name=?,fc_info=?,operator_id=?,operator_date=?"+
			" where fc_id=?");
			ps.setString(1, fc.getFc_name());
			ps.setString(2, fc.getFc_info());
			ps.setInt(3, operator_id);
			ps.setDate(4, new java.sql.Date(operator_date.getTime()));
			ps.setInt(5, fc.getFc_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closePS(ps);
		}
		
	}

	@Override
	public void deleteFirstCategory(int[] ids, int operator_id) {
		//删除一级分类
		String id=Arrays.toString(ids).replace('[','(').replace(']',')');
		PreparedStatement ps=null;
		Date operator_date = new Date();
		try {
			ps=conn.prepareStatement("update firstcategory set status=0,operator_id=?,operator_date=?"+
			" where fc_id in "+id);
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
	public List<FirstCategory> searchAllFc() {
		//查询所有一级分类（不分页）
		List<FirstCategory> list=new ArrayList<FirstCategory>();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select * from firstcategory where status=1");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FirstCategory fc=new FirstCategory();
				fc.setFc_id(rs.getInt("fc_id"));
				fc.setFc_name(rs.getString("fc_name"));
				list.add(fc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public FirstCategory getFirstCategoryByName(String fc_name) {
		//根据一级分类名称查询一级分类对象
		FirstCategory fc=new FirstCategory();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select * from firstcategory where fc_name=? ");
			ps.setString(1, fc_name);;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fc.setFc_id(rs.getInt("fc_id"));
				fc.setFc_name(rs.getString("fc_name"));
				fc.setFc_info(rs.getString("fc_info"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fc;
	}

	@Override
	public void addSecondCategory(SecondCategory sc, int operator_id) {
		//添加二级分类
		PreparedStatement ps=null;
		int status=1;
		Date operator_date=new Date();
		try {
			ps=conn.prepareStatement("insert into secondcategory values(seq_sc.nextval,?,?,?,?,?,?)");
			ps.setString(1, sc.getSc_name());
			ps.setString(2, sc.getSc_info());
			ps.setInt(3, status);
			ps.setInt(4, operator_id);
			ps.setDate(5, new java.sql.Date(operator_date.getTime()));
			ps.setInt(6, sc.getFc().getFc_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closePS(ps);
		}
	}

	@Override
	public List<SecondCategory> searchPageSc(int pageNum) {
		//分页查询二级分类
		List<SecondCategory> list=new ArrayList<SecondCategory>();
		PreparedStatement ps=null;
		int pageSize=8;
		StringBuffer sbf=new StringBuffer("");
		sbf.append("select s.sc_id,s.sc_name,f.fc_name from secondcategory s, firstcategory f "
				+ "where s.fc_id = f.fc_id and s.status=1");
		try {
			ps=conn.prepareStatement(" select b.* from ( "
					+ " select a.*,rownum rw from ( "
					+ sbf.toString() +  "  ) a "
					+ " where rownum<= "+ (pageSize*pageNum) +" ) b  "
					+ " where rw>"+ pageSize*(pageNum-1));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SecondCategory sc=new SecondCategory();
				FirstCategory fc=new FirstCategory();
				sc.setSc_id(rs.getInt("sc_id"));
				sc.setSc_name(rs.getString("sc_name"));
				fc.setFc_name(rs.getString("fc_name"));
				sc.setFc(fc);
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int searchScPageCount() {
		//查询二级分类列表页数
		int count=0;
		int pageSize=8;
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select count(*) c from secondcategory where status=1");
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
	public SecondCategory getSecondCategoryById(int sc_id) {
		//通过id查询二级分类
		SecondCategory sc=new SecondCategory();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select s.sc_name,s.sc_info,s.fc_id,f.fc_name from secondcategory s,firstcategory f "
					+ "where s.fc_id=f.fc_id and s.status=1 and s.sc_id="+sc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				FirstCategory fc=new FirstCategory();
				sc.setSc_id(sc_id);
				sc.setSc_name(rs.getString("sc_name"));
				sc.setSc_info(rs.getString("sc_info"));
				fc.setFc_id(rs.getInt("fc_id"));
				fc.setFc_name(rs.getString("fc_name"));
				sc.setFc(fc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc;
	}

	@Override
	public void updateSecondCategory(SecondCategory sc, int operator_id) {
		//修改二级分类
		PreparedStatement ps=null;
		Date operator_date = new Date();
		try {
			ps=conn.prepareStatement("update secondcategory set sc_name=?,sc_info=?,operator_id=?,operator_date=?,fc_id=?"+
			" where sc_id=?");
			ps.setString(1, sc.getSc_name());
			ps.setString(2, sc.getSc_info());
			ps.setInt(3, operator_id);
			ps.setDate(4, new java.sql.Date(operator_date.getTime()));
			ps.setInt(5, sc.getFc().getFc_id());
			ps.setInt(6, sc.getSc_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closePS(ps);
		}
	}

	@Override
	public void deleteSecondCategory(int[] ids, int operator_id) {
		//删除二级分类
		String id=Arrays.toString(ids).replace('[','(').replace(']',')');
		PreparedStatement ps=null;
		Date operator_date = new Date();
		try {
			ps=conn.prepareStatement("update secondcategory set status=0,operator_id=?,operator_date=?"+
			" where sc_id in "+id);
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
	public List<SecondCategory> searchScByFcId(int fc_id) {
		//通过一级分类id查询下属的二级分类
		List<SecondCategory> list=new ArrayList<SecondCategory>();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select * from secondcategory where status=1 and fc_id="+fc_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SecondCategory sc=new SecondCategory();
				sc.setSc_id(rs.getInt("sc_id"));
				sc.setSc_name(rs.getString("sc_name"));
				list.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Supplier> searchAllSup() {
		//查询所有的供应商
		List<Supplier> list=new ArrayList<Supplier>();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select * from supplier where status=1");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Supplier sup=new Supplier();
				sup.setSupplier_id(rs.getInt("supplier_id"));
				sup.setSupplier_name(rs.getString("supplier_name"));
				list.add(sup);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public SecondCategory getSecondCategoryByName(String sc_name) {
		//通过二级分类名称获取二级分类对象
		SecondCategory sc=new SecondCategory();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select * from secondcategory where sc_name=? ");
			ps.setString(1, sc_name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				FirstCategory fc=new FirstCategory();
				fc.setFc_id(rs.getInt("fc_id"));
				sc.setSc_id(rs.getInt("sc_id"));
				sc.setSc_name(rs.getString("sc_name"));
				sc.setSc_info(rs.getString("sc_info"));
				sc.setFc(fc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc;
	}

	@Override
	public String searchFcNameById(int fc_id) {
		//通过一级分类id查询一级分类的名称
		PreparedStatement ps=null;
		String fc_name="";
		try {
			ps=conn.prepareStatement("select fc_name from firstcategory where fc_id="+fc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fc_name=rs.getString("fc_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fc_name;
	}

	@Override
	public String searchScNameById(int sc_id) {
		//通过二级分类id查询二级分类名
		PreparedStatement ps=null;
		String sc_name="";
		try {
			ps=conn.prepareStatement("select sc_name from secondcategory where sc_id="+sc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sc_name=rs.getString("sc_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc_name;
	}

	@Override
	public int checkFcName(String fc_name) {
		//校验一级分类名
		PreparedStatement ps=null;
		int count=0;
		try {
			ps=conn.prepareStatement("select count(*) c from firstcategory where fc_name=?");
			ps.setString(1, fc_name);
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
	public int checkScName(String sc_name) {
		//校验二级分类名
		PreparedStatement ps=null;
		int count=0;
		try {
			ps=conn.prepareStatement("select count(*) c from secondcategory where sc_name=?");
			ps.setString(1, sc_name);
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
	public int getCountOfScInFc(int fc_id) {
		//校验一级分类是否可以被删除
		PreparedStatement ps=null;
		int count=0;
		try {
			ps=conn.prepareStatement("select count(*) c from secondcategory where status=1 and fc_id="+fc_id);
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
