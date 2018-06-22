package com.neuedu.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.Product;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

/**
 * Servlet implementation class SearchFcProductServlet
 */
public class SearchFcProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFcProductServlet() {
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
		//获取一级分类下属所有商品
		String currentPageNumber = request.getParameter("pageNumFcPro");
		String currentFcId = request.getParameter("fcId");
		System.out.println(currentFcId);
		System.out.println(currentPageNumber);
		String fc_name = request.getParameter("fc_name");
		int pageNum=1;
		int fc_id=0;
		if (currentPageNumber != null && !"".equals(currentPageNumber)) {
			pageNum=Integer.parseInt(currentPageNumber);
		}
		if (currentFcId != null && !"".equals(currentFcId)) {
			fc_id=Integer.parseInt(currentFcId);
		}
		if (fc_name != null && !"".equals(fc_name)) {
			FirstCategory fc = CategoryService.getInstance().getFirstCategoryByName(fc_name);
			fc_id = fc.getFc_id();
		}
		
		List<Product> proList = ProductService.getInstance().searchProductByFc(fc_id,pageNum);
		int pageCount=ProductService.getInstance().searchFcProPageCount(fc_id);
		//获取所有一级分类
		System.out.println(proList.toString());
		List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
		//请求转发给一级分类下属商品页面
		request.setAttribute("fcList", fcList);	
		request.setAttribute("proList", proList);
		request.setAttribute("pageCount", pageCount);
		System.out.println(fc_id);
		request.getSession().setAttribute("fcId", fc_id);
		request.getSession().setAttribute("pageNumFcPro", pageNum);
		request.getRequestDispatcher("/FirstCategory/SearchFcProduct.jsp").forward(request, response);
	}

}
