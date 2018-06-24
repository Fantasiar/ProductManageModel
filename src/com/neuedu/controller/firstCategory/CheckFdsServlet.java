package com.neuedu.controller.firstCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.service.CategoryService;

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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		System.out.println("enter");
		if ("addFc".equals(action)) {
			String fc_name = request.getParameter("fc_name");
			boolean isExist=CategoryService.getInstance().checkFcName(fc_name);
			System.out.println(isExist);
			response.getWriter().write("{\"isExist\":"+isExist+"}");
		}else if ("addSc".equals(action)) {
			String sc_name = request.getParameter("sc_name");
			boolean isExist=CategoryService.getInstance().checkScName(sc_name);
			System.out.println(isExist);
			response.getWriter().write("{\"isExist\":"+isExist+"}");
		}
	}

}
