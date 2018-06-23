package com.neuedu.controller.product;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SearchProductServlet
 */
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
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
		String currentPageNumber = request.getParameter("pageNumPro");
		int pageNum=1;
	
//		Strng product_name=new String((String)session.getAttribute("product_name").getBytes("ISO-8859-1"));
		String product_name=request.getParameter("product_name");
		List<Product> proList = new ArrayList<Product>();
		int pageCount=0;
		if ("blank".equals(action)) {
				proList = ProductService.getInstance().findAllPageProduct(pageNum);
				pageCount=ProductService.getInstance().findAllPageCount();
				
		}else {
			if ("".equals(product_name)) {
				if (currentPageNumber != null && !"".equals(currentPageNumber)) {
					pageNum=Integer.parseInt(currentPageNumber);
				}
				proList = ProductService.getInstance().findAllPageProduct(pageNum);
				pageCount=ProductService.getInstance().findAllPageCount();
			}else {
				if (currentPageNumber != null && !"".equals(currentPageNumber ) && Integer.parseInt(currentPageNumber)!=1) {
					pageNum=Integer.parseInt(currentPageNumber);
				}
//					System.out.println(pageNum);
//					System.out.println(product_name);
					proList = ProductService.getInstance().findProductByName(product_name,pageNum);
					pageCount=ProductService.getInstance().findProductPageCount(product_name);
					System.out.println(proList);
			}
			
		}
		request.getSession().setAttribute("product_name", product_name);
		request.setAttribute("proList", proList);	
		request.setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("pageNumPro", pageNum);
		request.getRequestDispatcher("/Product/SearchProduct.jsp").forward(request, response);
	}

}
