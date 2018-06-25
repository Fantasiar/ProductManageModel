package com.neuedu.controller.firstCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.service.CategoryService;

/**
 * Servlet implementation class EditFirstCategoryServlet
 */
public class EditFirstCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFirstCategoryServlet() {
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
		//本servlet用于修改一级分类
		//设置中文编码
		request.setCharacterEncoding("utf-8");
		//根据不同的action执行不同的操作
		String action = request.getParameter("action");	
		if("edit".equals(action)){
			//获取要修改的一级分类对象
			doEditFirstCategory(request,response);
		}else if("update".equals(action)){
			//更新一级分类
			doUpdateFirstCategory(request,response);
		}
	}

	//更新一级分类
	private void doUpdateFirstCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int operator_id=110;
		//获取修改后的一级分类参数
		String fc_id = request.getParameter("fc_id");
		String fc_name = request.getParameter("fc_name");
		String fc_info = request.getParameter("fc_info");
		String pageNum = request.getSession().getAttribute("pageNumFc").toString();
		//封装一级分类对象
		FirstCategory fc=new FirstCategory();
		fc.setFc_id(Integer.parseInt(fc_id));
		fc.setFc_name(fc_name);
		fc.setFc_info(fc_info);
		//更新一级分类对象
		CategoryService.getInstance().updateFirstCategory(fc,operator_id);
		response.sendRedirect(request.getContextPath()+"/searchFirstCategoryServlet?action=fc&pageNumFc="+pageNum);
	}

	//获取要修改的一级分类对象
	private void doEditFirstCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据id查询一级分类对象
		String fc_id = request.getParameter("fc_id");
		FirstCategory fc=CategoryService.getInstance().getFirstCategoryById(Integer.parseInt(fc_id));
		request.setAttribute("fc", fc);
		request.getRequestDispatcher("/FirstCategory/EditFirstCategory.jsp").forward(request, response);
	}

}
