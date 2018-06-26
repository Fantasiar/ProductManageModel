package com.neuedu.controller.secondCategory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

/**
 * Servlet implementation class SearchSecondCategoryServlet
 */
public class SearchSecondCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSecondCategoryServlet() {
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
		//本servlet用于获取二级分类列表
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("sc".equals(action)) {
			//用于二级类名分页
			
			//获取当前页码
			String currentPageNumber = request.getParameter("pageNumSc");
			int pageNum=1;
			if (currentPageNumber != null && !"".equals(currentPageNumber)) {
				//如果当前的页码不为空，则将pageNum改为当前页码
				pageNum=Integer.parseInt(currentPageNumber);
			}
			//获取二级分类列表和总页数
			List<SecondCategory> scList=CategoryService.getInstance().searchPageSc(pageNum);
			int pageCount=CategoryService.getInstance().searchScPageCount();
			//  遍历二级分类列表，根据id查询是否有下属的商品，若有下属商品则不可删除
			//  ，并根据查询结果为二级分类对象设置是否可删除的属性
			for (SecondCategory sc : scList) {
				int sc_id = sc.getSc_id();
				boolean isDelete=ProductService.getInstance().searchProCountOfSc(sc_id);
				sc.setDelete(isDelete);
			}
			//请求转发到 修改/删除一级分类页面
			request.setAttribute("scList", scList);
			request.setAttribute("pageCount", pageCount);
			request.getSession().setAttribute("pageNumSc", pageNum);
			request.getRequestDispatcher("/SecondCategory/AlterSecondCategory.jsp").forward(request, response);;
		}
	}

}
