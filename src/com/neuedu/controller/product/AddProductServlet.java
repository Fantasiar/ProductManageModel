package com.neuedu.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.Product;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.po.Supplier;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

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
		//本servlet用于添加新商品
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("findSc".equals(action)) {
			//通过ajax异步查询一级分类下属的所有二级分类，用于查询二级分类下属商品页面
			
			//根据一级类名查询下属的二级分类集合
			String fc_name = request.getParameter("fc_name");
			FirstCategory fc=CategoryService.getInstance().getFirstCategoryByName(fc_name);
			int fc_id = fc.getFc_id();
			List<SecondCategory> scList=CategoryService.getInstance().searchScByFcId(fc_id);
			//使用谷歌的gson jar包将list转换为json数据格式，并返还给前端
			Gson gson=new Gson();
			String str = gson.toJson(scList);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(str);
			
		}else if ("addPro".equals(action)) {
			//通过ajax异步查询一级分类下属的所有二级分类，用于添加商品页面
		
			int operator_id=110;
			
			//获取商品参数
			String product_name = request.getParameter("product_name");
			String fc_name = request.getParameter("fc_name");
			String sc_name = request.getParameter("sc_name");
			String measure = request.getParameter("measure");
			String original_price = request.getParameter("original_price");
			String discount = request.getParameter("discount");
			String cost_price = request.getParameter("cost_price");
			String version = request.getParameter("version");
			String supplier_name = request.getParameter("supplier_name");
			String publisher = request.getParameter("publisher");
			String shelf_life = request.getParameter("shelf_life");
			String remarks = request.getParameter("remarks");
			
			//先封装一级分类、二级分类、供应商对象，然后将三个对象都封装到商品对象中
			FirstCategory fc = CategoryService.getInstance().getFirstCategoryByName(fc_name);
			SecondCategory sc = CategoryService.getInstance().getSecondCategoryByName(sc_name);
			Supplier sup = ProductService.getInstance().getSupplierByName(supplier_name);
			Product product=new Product();
			product.setProduct_name(product_name);
			product.setFc(fc);
			product.setSc(sc);
			product.setMeasure(measure);
			product.setOriginal_price(Double.parseDouble(original_price));
			product.setDiscount(Double.parseDouble(discount));
			product.setCost_price(Double.parseDouble(cost_price));
			product.setVersion(version);
			product.setSupplier(sup);
			product.setPublisher(publisher);
			product.setShelf_life(shelf_life);
			product.setRemarks(remarks);
			//刷新页面
			ProductService.getInstance().addProduct(product,operator_id);
			response.sendRedirect(request.getContextPath()+"/searchFirstCategoryServlet?action=addPro");

		}
	}

}
