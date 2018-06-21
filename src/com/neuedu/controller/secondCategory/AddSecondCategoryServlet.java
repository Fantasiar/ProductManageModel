package com.neuedu.controller.secondCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.service.CategoryService;

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
		// TODO Auto-generated method stub
		int operator_id=110;
		request.setCharacterEncoding("utf-8");
		String fc_name = request.getParameter("fc_name");
		String sc_name = request.getParameter("sc_name");
		String sc_info = request.getParameter("sc_info");
		
		FirstCategory fc=CategoryService.getInstance().getFirstCategoryByName(fc_name);
		SecondCategory sc=new SecondCategory();
		sc.setSc_name(sc_name);
		sc.setSc_info(sc_info);
		sc.setFc(fc);
		CategoryService.getInstance().addSecondCategory(sc,operator_id);
		response.sendRedirect(request.getContextPath()+"/searchFirstCategoryServlet?action=sc");
	}

}
