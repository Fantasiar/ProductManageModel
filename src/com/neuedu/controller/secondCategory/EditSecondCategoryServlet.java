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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");	
		if("edit".equals(action)){
			doEditSecondCategory(request,response);
		}else if("update".equals(action)){
			doUpdateSecondCategory(request,response);
		}
	}

	private void doUpdateSecondCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int operator_id=110;
		String sc_id = request.getParameter("sc_id");
		String sc_name = request.getParameter("sc_name");
		String sc_info = request.getParameter("sc_info");
		
		String fc_name = request.getParameter("fc_name");
		String pageNum = request.getSession().getAttribute("pageNumSc").toString();
		SecondCategory sc=new SecondCategory();
		FirstCategory fc=CategoryService.getInstance().getFirstCategoryByName(fc_name);
		
		sc.setSc_id(Integer.parseInt(sc_id));
		sc.setSc_name(sc_name);
		sc.setSc_info(sc_info);	
		sc.setFc(fc);
		CategoryService.getInstance().updateSecondCategory(sc,operator_id);
		response.sendRedirect(request.getContextPath()+"/searchSecondCategoryServlet?action=sc&pageNumSc="+pageNum);
	}

	private void doEditSecondCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sc_id = request.getParameter("sc_id");
		SecondCategory sc=CategoryService.getInstance().getSecondCategoryById(Integer.parseInt(sc_id));	
		List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
		request.setAttribute("sc", sc);
		request.setAttribute("fcList", fcList);
		request.getRequestDispatcher("/SecondCategory/EditSecondCategory.jsp").forward(request, response);
	}

}
