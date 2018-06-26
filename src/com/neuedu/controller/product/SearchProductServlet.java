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
		//本servlet用于查询商品
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		//根据不同的action执行不同的操作
		String action = request.getParameter("action");
		//获取当前页码
		String currentPageNumber = request.getParameter("pageNumPro");
		int pageNum=1;
		int product_id=0;
		
		List<Product> proList = new ArrayList<Product>();
		int pageCount=0;
		if ("blank".equals(action)) {
			//用于首次点击进入查询商品界面，系统将默认查询出所有商品列表，并进行分页展示
				proList = ProductService.getInstance().findAllPageProduct(pageNum);
				pageCount=ProductService.getInstance().findAllPageCount();
				//遍历商品列表，根据商品在订单中的状态，为每个商品都设置是否可删除的属性
				for (Product pro : proList) {
					int pro_id = pro.getProduct_id();
					boolean isDelete=ProductService.getInstance().checkProDelete(pro_id);
					pro.setDelete(isDelete);
				}
				
		}else {
			//用于非第一次进入商品查询界面的情况（包括点击翻页或输入商品名进行查询）
			String product_name=request.getParameter("product_name");
			product_id = ProductService.getInstance().searchProductIdByName(product_name);
			if (product_id != 0) {
				//session中存放有商品id的数据，则执行根据商品名查询商品的操作
				if (currentPageNumber != null && !"".equals(currentPageNumber )) {
					//如果当前页码不等于pageNum，则修改pageNum的值为当前页码
					pageNum=Integer.parseInt(currentPageNumber);
				}
					//根据商品id查询对应的商品
					proList = ProductService.getInstance().findProductByName(product_id,pageNum);
					pageCount=ProductService.getInstance().findProductPageCount(product_id);
					//遍历商品列表，根据商品在订单中的状态，为每个商品都设置是否可删除的属性
					for (Product pro : proList) {
						int pro_id = pro.getProduct_id();
						boolean isDelete=ProductService.getInstance().checkProDelete(pro_id);
						pro.setDelete(isDelete);
					}
				
			}else {
				//session中没有存放商品id的数据，则默认为查询所有商品的翻页操作
				if (currentPageNumber != null && !"".equals(currentPageNumber)) {
					pageNum=Integer.parseInt(currentPageNumber);
				}
				//查询并获得所有商品的列表
				proList = ProductService.getInstance().findAllPageProduct(pageNum);
				pageCount=ProductService.getInstance().findAllPageCount();
				//遍历商品列表，根据商品在订单中的状态，为每个商品都设置是否可删除的属性
				for (Product pro : proList) {
					int pro_id = pro.getProduct_id();
					boolean isDelete=ProductService.getInstance().checkProDelete(pro_id);
					pro.setDelete(isDelete);
				}
			}
			
		}
		//将商品id和页码存入session，便于分页
		request.getSession().setAttribute("product_id", product_id);
		request.setAttribute("proList", proList);	
		request.setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("pageNumPro", pageNum);
		request.getRequestDispatcher("/Product/SearchProduct.jsp").forward(request, response);
	}

}
