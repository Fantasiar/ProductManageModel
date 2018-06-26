package com.neuedu.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.Product;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.po.Supplier;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

/**
 * Servlet implementation class EditProductServlet
 */
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
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
		//本servlet用于修改商品信息
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		//根据不同的action执行不同的操作
		String action = request.getParameter("action");
		if("edit".equals(action)){
			//获取要修改的商品对象
			doEditProduct(request,response);
		}else if("update".equals(action)){
			//更新商品信息
			doUpdateProduct(request,response);
		}
		
	}
	
	//更新商品信息
	private void doUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int operator_id=110;
		//获取修改后的商品参数
		String product_id = request.getParameter("product_id");
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
		
		//从Cookie中获得当前操作员的id
		Cookie myCookie[]=request.getCookies();
		for(int i=0;i<myCookie.length;i++) {
			Cookie newCookie=myCookie[i];
			if (newCookie.getName().equals("adminID")) {
				operator_id=Integer.parseInt(newCookie.getValue());
			}
		}
		
		//封装修改后的商品对象
		FirstCategory fc = CategoryService.getInstance().getFirstCategoryByName(fc_name);
		SecondCategory sc = CategoryService.getInstance().getSecondCategoryByName(sc_name);
		Supplier sup = ProductService.getInstance().getSupplierByName(supplier_name);
		Product product=new Product();
		product.setProduct_id(Integer.parseInt(product_id));
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
		//更新商品对象
		ProductService.getInstance().updateProduct(product,operator_id);
		try {
			request.getRequestDispatcher("/searchProductServlet?product_id="+product_id).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	//获取要修改的商品对象
	private void doEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据id查询商品对象
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
		
		//获取一级分类选择列表和供应商列表中的默认数据
		List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
		List<Supplier> supList=CategoryService.getInstance().searchAllSup();
		request.setAttribute("fcList", fcList);
		request.setAttribute("supList", supList);
		//将要修改的商品信息请求转发到修改商品的界面
		request.setAttribute("product", product);
		request.getRequestDispatcher("/Product/EditProduct.jsp").forward(request, response);
	}

}
