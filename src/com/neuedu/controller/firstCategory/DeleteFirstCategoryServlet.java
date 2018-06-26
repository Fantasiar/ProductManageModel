package com.neuedu.controller.firstCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.service.CategoryService;

/**
 * Servlet implementation class DeleteFirstCategoryServlet
 */
public class DeleteFirstCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFirstCategoryServlet() {
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
		//本servlet用于删除一级分类
		
		int operator_id=111;
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		//获取要删除的一级分类的id集合
		String[] chks = request.getParameterValues("chk");
		int[] ids=new int[chks.length];
		for (int i = 0; i < chks.length; i++) {
			ids[i]=Integer.parseInt(chks[i]);
		}
		
		//从Cookie中获得当前操作员的id
		Cookie myCookie[]=request.getCookies();
		for(int i=0;i<myCookie.length;i++) {
			Cookie newCookie=myCookie[i];
			if (newCookie.getName().equals("adminID")) {
				operator_id=Integer.parseInt(newCookie.getValue());
			}
		}
		
		//从数据库中删除集合中id对应的一级分类
		CategoryService.getInstance().deleteFirstCategory(ids,operator_id);
		//刷新页面，更新数据
		String pageNum=request.getSession().getAttribute("pageNumFc").toString();
		response.sendRedirect(request.getContextPath()+"/searchFirstCategoryServlet?action=fc&pageNumFc="+pageNum);
	}

}
