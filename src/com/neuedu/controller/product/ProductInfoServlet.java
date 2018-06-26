package com.neuedu.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.dao.CategoryDaoImp;
import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.po.Product;
import com.neuedu.model.service.ProductService;

/**
 * Servlet implementation class ProductInfoServlet
 */
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInfoServlet() {
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
		//本sevlet用于查看选定商品的详细信息
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		
		//根据商品id去数据库查询商品对象并进行封装
		String product_id = request.getParameter("product_id");
		Product product = ProductService.getInstance().searchProductInfo(Integer.parseInt(product_id));
		int fc_id = product.getFc().getFc_id();
		int sc_id = product.getSc().getSc_id();
		int supplier_id = product.getSupplier().getSupplier_id();
		String fc_name=CategoryService.getInstance().searchFcNameById(fc_id);
		String sc_name=CategoryService.getInstance().searchScNameById(sc_id);
		String supplier_name=ProductService.getInstance().searchSupNameById(supplier_id);
		product.getFc().setFc_name(fc_name);
		product.getSc().setSc_name(sc_name);
		product.getSupplier().setSupplier_name(supplier_name);
		//将封转好的商品对象转发给查看商品详情界面
		request.setAttribute("product", product);
		request.getRequestDispatcher("/Product/ProductInfo.jsp").forward(request, response);
	}

}
