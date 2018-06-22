package com.neuedu.controller.firstCategory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.Product;
import com.neuedu.model.po.Supplier;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

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
		String action = request.getParameter("action");
		if ("fc".equals(action)) {
			//一级分类分页
			String currentPageNumber = request.getParameter("pageNumFc");
			int pageNum=1;
			if (currentPageNumber != null && !"".equals(currentPageNumber)) {
				pageNum=Integer.parseInt(currentPageNumber);
			}
			
			List<FirstCategory> fcList=CategoryService.getInstance().searchPageFc(pageNum);
			int pageCount=CategoryService.getInstance().searchFcPageCount();
			
			request.setAttribute("fcList", fcList);
			request.setAttribute("pageCount", pageCount);
			request.getSession().setAttribute("pageNumFc", pageNum);
			request.getRequestDispatcher("/FirstCategory/AlterFirstCategory.jsp").forward(request, response);
		}else if ("sc".equals(action)) {
			//用于添加二级分类页面的一级分类select列表
			List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
			request.setAttribute("fcList", fcList);
			request.getRequestDispatcher("/SecondCategory/AddSecondCategory.jsp").forward(request, response);
		}else if ("addPro".equals(action)) {
			//用于添加商品页面的一级分类列表和供应商列表
			List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
			List<Supplier> supList=CategoryService.getInstance().searchAllSup();
			request.setAttribute("fcList", fcList);
			request.setAttribute("supList", supList);
			request.getRequestDispatcher("/Product/AddProduct.jsp").forward(request, response);
		}else if ("fcPro".equals(action)) {
			//用于查询一级分类下属页面的初始化一级分类选择列表
			List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
			request.setAttribute("fcList", fcList);
			
			request.getRequestDispatcher("/FirstCategory/SearchFcProduct.jsp").forward(request, response);
		    
		}else if ("scPro".equals(action)) {
			List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
			request.setAttribute("fcList", fcList);
			
			request.getRequestDispatcher("/SecondCategory/SearchScProduct.jsp").forward(request, response);
		}
	
	}

}
