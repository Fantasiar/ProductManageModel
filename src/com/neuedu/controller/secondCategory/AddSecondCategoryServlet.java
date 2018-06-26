package com.neuedu.controller.secondCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.service.CategoryService;
import com.sun.org.apache.regexp.internal.RE;

/**
 * Servlet implementation class AddSecondCategoryServlet
 */
public class AddSecondCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSecondCategoryServlet() {
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
		//��servlet������Ӷ�������
		
		
		//�������ı���
		request.setCharacterEncoding("utf-8");
		int operator_id=110;
		
		//��Cookie�л�õ�ǰ����Ա��id
		Cookie myCookie[]=request.getCookies();
		for(int i=0;i<myCookie.length;i++) {
			Cookie newCookie=myCookie[i];
			if (newCookie.getName().equals("adminID")) {
				operator_id=Integer.parseInt(newCookie.getValue());
			}
		}
		
		String fc_name = request.getParameter("fc_name");
		String sc_name = request.getParameter("sc_name");
		String sc_info = request.getParameter("sc_info");
		//���ݻ�õ����Բ�����װ�����������
		FirstCategory fc=CategoryService.getInstance().getFirstCategoryByName(fc_name);
		SecondCategory sc=new SecondCategory();
		sc.setSc_name(sc_name);
		sc.setSc_info(sc_info);
		sc.setFc(fc);
		//����װ�õĶ����������������ݿ�
		CategoryService.getInstance().addSecondCategory(sc,operator_id);
		//ˢ��ҳ��
		response.sendRedirect(request.getContextPath()+"/searchFirstCategoryServlet?action=sc");
	}

}
