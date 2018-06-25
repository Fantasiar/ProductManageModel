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
		//本servlet用于获取一级分类列表
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("fc".equals(action)) {
			//用于一级类名分页
			
			//获取当前页数
			String currentPageNumber = request.getParameter("pageNumFc");
			int pageNum=1;
			//如果当前页数不为1，修改pageNum为当前页数
			if (currentPageNumber != null && !"".equals(currentPageNumber)) {
				pageNum=Integer.parseInt(currentPageNumber);
			}
			//获取一级分类列表和总页数
			List<FirstCategory> fcList=CategoryService.getInstance().searchPageFc(pageNum);
			int pageCount=CategoryService.getInstance().searchFcPageCount();
			//  遍历一级分类列表，根据id查询是否有下属的二级分类，若有下属二级分类则不可删除
			//  ，并根据查询结果为一级分类对象设置是否可删除的属性
			for (FirstCategory fc : fcList) {
				int fc_id = fc.getFc_id();
				boolean isDelete=CategoryService.getInstance().getCountOfScInFc(fc_id);
				fc.setDelete(isDelete);
			}
			//请求转发到 修改/删除一级分类页面
			request.setAttribute("fcList", fcList);
			request.setAttribute("pageCount", pageCount);
			request.getSession().setAttribute("pageNumFc", pageNum);
			request.getRequestDispatcher("/FirstCategory/AlterFirstCategory.jsp").forward(request, response);
		
		}else if ("sc".equals(action)) {
			//用于添加二级分类页面的一级分类选择列表
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
			//用于查询二级分类下属页面的初始化一级分类选择列表
			List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
			request.setAttribute("fcList", fcList);
			request.getRequestDispatcher("/SecondCategory/SearchScProduct.jsp").forward(request, response);
		}
	
	}

}
