package com.neuedu.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.service.CategoryService;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
	//	System.out.println("enter addpro");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("findSc".equals(action)) {
			String fc_name = request.getParameter("fc_name");
			FirstCategory fc=CategoryService.getInstance().getFirstCategoryByName(fc_name);
			int fc_id = fc.getFc_id();
			List<SecondCategory> scList=CategoryService.getInstance().searchScByFcId(fc_id);
			Gson gson=new Gson();
			String str = gson.toJson(scList);
		//	System.out.println(str);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(str);
			
		}
	}

}
