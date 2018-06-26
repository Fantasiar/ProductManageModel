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

/**
 * Servlet implementation class EditSecondCategoryServlet
 */
public class EditSecondCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSecondCategoryServlet() {
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
		//本servlet用于修改二级分类
		
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		//根据不同的action执行不同的操作
		String action = request.getParameter("action");	
		if("edit".equals(action)){
			//获取要修改的二级分类对象
			doEditSecondCategory(request,response);
		}else if("update".equals(action)){
			//更新二级分类
			doUpdateSecondCategory(request,response);
		}
	}
	
	//更新二级分类
	private void doUpdateSecondCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int operator_id=110;
		//获取修改后的二级分类参数
		String sc_id = request.getParameter("sc_id");
		String sc_name = request.getParameter("sc_name");
		String sc_info = request.getParameter("sc_info");
		String fc_name = request.getParameter("fc_name");
		String pageNum = request.getSession().getAttribute("pageNumSc").toString();
		SecondCategory sc=new SecondCategory();
		//封装二级分类对象
		FirstCategory fc=CategoryService.getInstance().getFirstCategoryByName(fc_name);
		sc.setSc_id(Integer.parseInt(sc_id));
		sc.setSc_name(sc_name);
		sc.setSc_info(sc_info);	
		sc.setFc(fc);
		//更新二级分类对象
		CategoryService.getInstance().updateSecondCategory(sc,operator_id);
		response.sendRedirect(request.getContextPath()+"/searchSecondCategoryServlet?action=sc&pageNumSc="+pageNum);
	}
	
	//获取要修改的二级分类对象
	private void doEditSecondCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据id查询二级分类对象
		String sc_id = request.getParameter("sc_id");
		SecondCategory sc=CategoryService.getInstance().getSecondCategoryById(Integer.parseInt(sc_id));	
		//获取所有一级分类列表，用于修改二级分类界面的select组件
		List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
		request.setAttribute("sc", sc);
		request.setAttribute("fcList", fcList);
		request.getRequestDispatcher("/SecondCategory/EditSecondCategory.jsp").forward(request, response);
	}

}
