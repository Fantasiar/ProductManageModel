package com.neuedu.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.Product;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

/**
 * Servlet implementation class SearchScProductServlet
 */
public class SearchScProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchScProductServlet() {
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
		//本servlet用于查询二级分类下属商品
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		//获取当前页码
		String currentPageNumber = request.getParameter("pageNumScPro");
		String currentScId = request.getParameter("scId");
		String sc_name = request.getParameter("sc_name");
		int pageNum=1;
		int sc_id=0;
		if (currentPageNumber != null && !"".equals(currentPageNumber)) {
			//如果当前的页码不为空，则将pageNum改为当前页码
			pageNum=Integer.parseInt(currentPageNumber);
		}
		if (currentScId != null && !"".equals(currentScId)) {
			//如果session中存放的当前二级分类id不为空，则将二级分类id赋给sc_id
			sc_id=Integer.parseInt(currentScId);
		}
		if (sc_name != null && !"".equals(sc_name)) {
			//如果request传来的二级类名sc_name不为空，则通过该类名去数据库中查询出该类名对应的id
			SecondCategory sc = CategoryService.getInstance().getSecondCategoryByName(sc_name);
			sc_id = sc.getSc_id();
		}
		//根据二级类id从数据库查询该二级类下属的所有商品
		List<Product> proList = ProductService.getInstance().searchProductBySc(sc_id,pageNum);
		int pageCount=ProductService.getInstance().searchScProPageCount(sc_id);
		//获取所有一级分类用于select列表
		List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
		//将二级类id和页码存入session，便于分页
		request.setAttribute("fcList", fcList);	
		request.setAttribute("proList", proList);
		request.setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("scId", sc_id);
		request.getSession().setAttribute("pageNumScPro", pageNum);
		request.getRequestDispatcher("/SecondCategory/SearchScProduct.jsp").forward(request, response);
	}

}
