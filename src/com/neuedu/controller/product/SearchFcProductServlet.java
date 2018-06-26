package com.neuedu.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.Product;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

/**
 * Servlet implementation class SearchFcProductServlet
 */
public class SearchFcProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFcProductServlet() {
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
		//��servlet���ڲ�ѯһ������������Ʒ
		
		//�������ı���
		request.setCharacterEncoding("utf-8");
		//��ȡ��ǰҳ��
		String currentPageNumber = request.getParameter("pageNumFcPro");
		String currentFcId = request.getParameter("fcId");
		String fc_name = request.getParameter("fc_name");
		int pageNum=1;
		int fc_id=0;
		if (currentPageNumber != null && !"".equals(currentPageNumber)) {
			//�����ǰ��ҳ�벻Ϊ�գ���pageNum��Ϊ��ǰҳ��
			pageNum=Integer.parseInt(currentPageNumber);
		}
		if (currentFcId != null && !"".equals(currentFcId)) {
			//���session�д�ŵĵ�ǰһ������id��Ϊ�գ���һ������id����fc_id
			fc_id=Integer.parseInt(currentFcId);
		}
		if (fc_name != null && !"".equals(fc_name)) {
			//���request������һ������fc_name��Ϊ�գ���ͨ��������ȥ���ݿ��в�ѯ����������Ӧ��id
			FirstCategory fc = CategoryService.getInstance().getFirstCategoryByName(fc_name);
			fc_id = fc.getFc_id();
		}
		//����һ����id�����ݿ��ѯ��һ����������������Ʒ
		List<Product> proList = ProductService.getInstance().searchProductByFc(fc_id,pageNum);
		int pageCount=ProductService.getInstance().searchFcProPageCount(fc_id);
		//��ȡ����һ����������select�б�
		List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
		//��һ����id��ҳ�����session�����ڷ�ҳ
		request.setAttribute("fcList", fcList);	
		request.setAttribute("proList", proList);
		request.setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("fcId", fc_id);
		request.getSession().setAttribute("pageNumFcPro", pageNum);
		//����ת����һ������������Ʒҳ��
		request.getRequestDispatcher("/FirstCategory/SearchFcProduct.jsp").forward(request, response);
	}

}
