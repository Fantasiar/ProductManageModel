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
import com.neuedu.utils.DBUtils;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class CategoryDaoImp implements CategoryDao{
	private Connection conn;
	
	public CategoryDaoImp(Connection conn) {
		this.conn=conn;
	}

	@Override
	public void addFirstCategory(FirstCategory fc, int operator_id) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		FirstCategory fc=new FirstCategory();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("select * from firstcategory where fc_id=? ");
			ps.setInt(1, fc_id);
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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

	
}
