package com.neuedu.controller.firstCategory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.service.CategoryService;

/**
 * Servlet implementation class SearchFirstCategory
 */
public class SearchFirstCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFirstCategoryServlet() {
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
		String currentPageNumber = request.getParameter("pageNum");
		int pageNum=1;
		if (currentPageNumber != null && !"".equals(currentPageNumber)) {
			pageNum=Integer.parseInt(currentPageNumber);
		}
		
		List<FirstCategory> fcList=CategoryService.getInstance().searchPageFc(pageNum);
		int pageCount=CategoryService.getInstance().searchFcPageCount();
		
		request.setAttribute("fcList", fcList);
		request.setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("pageNum", pageNum);
		request.getRequestDispatcher("/FirstCategory/AlterFirstCategory.jsp").forward(request, response);
	}

}
