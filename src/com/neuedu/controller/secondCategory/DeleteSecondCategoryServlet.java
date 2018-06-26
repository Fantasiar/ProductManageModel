package com.neuedu.controller.secondCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.service.CategoryService;

/**
 * Servlet implementation class DeleteSecondCategoryServlet
 */
public class DeleteSecondCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSecondCategoryServlet() {
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
		//��servlet����ɾ��һ������
		
		int operator_id=111;
		//�������ı���
		request.setCharacterEncoding("utf-8");
		//��ȡҪɾ���Ķ��������id����
		String[] chks = request.getParameterValues("chk");
		int[] ids=new int[chks.length];
		for (int i = 0; i < chks.length; i++) {
			ids[i]=Integer.parseInt(chks[i]);
		}
		//�����ݿ���ɾ��������id��Ӧ�Ķ�������
		CategoryService.getInstance().deleteSecondCategory(ids,operator_id);
		//ˢ��ҳ�棬��������
		String pageNum=request.getSession().getAttribute("pageNumSc").toString();
		response.sendRedirect(request.getContextPath()+"/searchSecondCategoryServlet?action=sc&pageNumSc="+pageNum);
	}

}
