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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");	
		if("edit".equals(action)){
			doEditFirstCategory(request,response);
		}else if("update".equals(action)){
			doUpdateFirstCategory(request,response);
		}
	}

	private void doUpdateFirstCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int operator_id=110;
		String fc_id = request.getParameter("fc_id");
		String fc_name = request.getParameter("fc_name");
		String fc_info = request.getParameter("fc_info");
		String pageNum = request.getSession().getAttribute("pageNum").toString();
		FirstCategory fc=new FirstCategory();
		fc.setFc_id(Integer.parseInt(fc_id));
		fc.setFc_name(fc_name);
		fc.setFc_info(fc_info);
		CategoryService.getInstance().updateFirstCategory(fc,operator_id);
		response.sendRedirect(request.getContextPath()+"/searchFirstCategoryServlet?pageNum="+pageNum);
	}

	private void doEditFirstCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fc_id = request.getParameter("fc_id");
		FirstCategory fc=CategoryService.getInstance().getFirstCategoryById(Integer.parseInt(fc_id));
		request.setAttribute("fc", fc);
		request.getRequestDispatcher("/FirstCategory/EditFirstCategory.jsp").forward(request, response);
	}

}
