package com.neuedu.controller.firstCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.service.CategoryService;

/**
 * Servlet implementation class AddFirstCategoryServlet
 */
public class AddFirstCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFirstCategoryServlet() {
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
		//��servlet��������µ�һ������
		
		//�������ı���
		request.setCharacterEncoding("utf-8");
		//���ݻ�õ����Բ�����װһ���������
		FirstCategory fc=new FirstCategory();
		fc.setFc_name(request.getParameter("fc_name"));
		fc.setFc_info(request.getParameter("fc_info"));
		int operator_id=110;
		//����װ�õ�һ���������������ݿ�
		CategoryService.getInstance().addFirstCategory(fc,operator_id);
		//ˢ��ҳ��
		response.sendRedirect(request.getContextPath()+"/FirstCategory/AddFirstCategory.jsp");
	}

}
