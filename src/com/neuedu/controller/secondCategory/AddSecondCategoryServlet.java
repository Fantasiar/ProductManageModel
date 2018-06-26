package com.neuedu.controller.secondCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.service.CategoryService;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Servlet implementation class AddSecondCategoryServlet
 */
public class AddSecondCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSecondCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//本servlet用于添加二级分类
		
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		int operator_id=110;
		
		//从Cookie中获得当前操作员的id
		Cookie myCookie[]=request.getCookies();
		for(int i=0;i<myCookie.length;i++) {
			Cookie newCookie=myCookie[i];
			if (newCookie.getName().equals("adminID")) {
				operator_id=Integer.parseInt(newCookie.getValue());
			}
		}
		
		String fc_name = request.getParameter("fc_name");
		String sc_name = request.getParameter("sc_name");
		String sc_info = request.getParameter("sc_info");
		//根据获得的属性参数封装二级分类对象
		FirstCategory fc=CategoryService.getInstance().getFirstCategoryByName(fc_name);
		SecondCategory sc=new SecondCategory();
		sc.setSc_name(sc_name);
		sc.setSc_info(sc_info);
		sc.setFc(fc);
		//将封装好的二级分类对象存入数据库
		CategoryService.getInstance().addSecondCategory(sc,operator_id);
		//刷新页面
		response.sendRedirect(request.getContextPath()+"/searchFirstCategoryServlet?action=sc");
	}

}
