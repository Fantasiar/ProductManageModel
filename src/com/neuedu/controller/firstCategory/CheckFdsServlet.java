package com.neuedu.controller.firstCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

/**
 * Servlet implementation class CheckFdsServlet
 */
public class CheckFdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckFdsServlet() {
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
		//本servlet用于ajax校验添加的一级类名、二级类名、商品名是否已存在
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		//根据不同的action值执行不同的操作
		if ("addFc".equals(action)) {
			//校验一级分类名是否存在
			String fc_name = request.getParameter("fc_name");
			boolean isExist=CategoryService.getInstance().checkFcName(fc_name);
			response.getWriter().write("{\"isExist\":"+isExist+"}");
			
		}else if ("addSc".equals(action)) {
			//校验二级分类名是否存在
			String sc_name = request.getParameter("sc_name");
			boolean isExist=CategoryService.getInstance().checkScName(sc_name);
			response.getWriter().write("{\"isExist\":"+isExist+"}");
			
		}else if ("addPro".equals(action)) {
			//校验商品名是否存在
			String product_name = request.getParameter("product_name");
			boolean isExist=ProductService.getInstance().checkProductName(product_name);
			System.out.println(isExist);
			response.getWriter().write("{\"isExist\":"+isExist+"}");
		}
	}

}
