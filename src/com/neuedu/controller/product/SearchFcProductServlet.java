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
		//本servlet用于查询一级分类下属商品
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		//获取当前页码
		String currentPageNumber = request.getParameter("pageNumFcPro");
		String currentFcId = request.getParameter("fcId");
		String fc_name = request.getParameter("fc_name");
		int pageNum=1;
		int fc_id=0;
		if (currentPageNumber != null && !"".equals(currentPageNumber)) {
			//如果当前的页码不为空，则将pageNum改为当前页码
			pageNum=Integer.parseInt(currentPageNumber);
		}
		if (currentFcId != null && !"".equals(currentFcId)) {
			//如果session中存放的当前一级分类id不为空，则将一级分类id赋给fc_id
			fc_id=Integer.parseInt(currentFcId);
		}
		if (fc_name != null && !"".equals(fc_name)) {
			//如果request传来的一级类名fc_name不为空，则通过该类名去数据库中查询出该类名对应的id
			FirstCategory fc = CategoryService.getInstance().getFirstCategoryByName(fc_name);
			fc_id = fc.getFc_id();
		}
		//根据一级类id从数据库查询该一级类下属的所有商品
		List<Product> proList = ProductService.getInstance().searchProductByFc(fc_id,pageNum);
		int pageCount=ProductService.getInstance().searchFcProPageCount(fc_id);
		//获取所有一级分类用于select列表
		List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
		//将一级类id和页码存入session，便于分页
		request.setAttribute("fcList", fcList);	
		request.setAttribute("proList", proList);
		request.setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("fcId", fc_id);
		request.getSession().setAttribute("pageNumFcPro", pageNum);
		//请求转发给一级分类下属商品页面
		request.getRequestDispatcher("/FirstCategory/SearchFcProduct.jsp").forward(request, response);
	}

}
