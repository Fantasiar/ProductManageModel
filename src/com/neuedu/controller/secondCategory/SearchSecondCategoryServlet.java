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
		//��servlet���ڻ�ȡ���������б�
		
		//�������ı���
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("sc".equals(action)) {
			//���ڶ���������ҳ
			
			//��ȡ��ǰҳ��
			String currentPageNumber = request.getParameter("pageNumSc");
			int pageNum=1;
			if (currentPageNumber != null && !"".equals(currentPageNumber)) {
				//�����ǰ��ҳ�벻Ϊ�գ���pageNum��Ϊ��ǰҳ��
				pageNum=Integer.parseInt(currentPageNumber);
			}
			//��ȡ���������б����ҳ��
			List<SecondCategory> scList=CategoryService.getInstance().searchPageSc(pageNum);
			int pageCount=CategoryService.getInstance().searchScPageCount();
			//  �������������б�����id��ѯ�Ƿ�����������Ʒ������������Ʒ�򲻿�ɾ��
			//  �������ݲ�ѯ���Ϊ����������������Ƿ��ɾ��������
			for (SecondCategory sc : scList) {
				int sc_id = sc.getSc_id();
				boolean isDelete=ProductService.getInstance().searchProCountOfSc(sc_id);
				sc.setDelete(isDelete);
			}
			//����ת���� �޸�/ɾ��һ������ҳ��
			request.setAttribute("scList", scList);
			request.setAttribute("pageCount", pageCount);
			request.getSession().setAttribute("pageNumSc", pageNum);
			request.getRequestDispatcher("/SecondCategory/AlterSecondCategory.jsp").forward(request, response);;
		}
	}

}
