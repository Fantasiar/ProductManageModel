package com.neuedu.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.po.FirstCategory;
import com.neuedu.model.po.Product;
import com.neuedu.model.po.SecondCategory;
import com.neuedu.model.service.CategoryService;
import com.neuedu.model.service.ProductService;

/**
 * Servlet implementation class SearchScProductServlet
 */
public class SearchScProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchScProductServlet() {
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
		//��servlet���ڲ�ѯ��������������Ʒ
		
		//�������ı���
		request.setCharacterEncoding("utf-8");
		//��ȡ��ǰҳ��
		String currentPageNumber = request.getParameter("pageNumScPro");
		String currentScId = request.getParameter("scId");
		String sc_name = request.getParameter("sc_name");
		int pageNum=1;
		int sc_id=0;
		if (currentPageNumber != null && !"".equals(currentPageNumber)) {
			//�����ǰ��ҳ�벻Ϊ�գ���pageNum��Ϊ��ǰҳ��
			pageNum=Integer.parseInt(currentPageNumber);
		}
		if (currentScId != null && !"".equals(currentScId)) {
			//���session�д�ŵĵ�ǰ��������id��Ϊ�գ��򽫶�������id����sc_id
			sc_id=Integer.parseInt(currentScId);
		}
		if (sc_name != null && !"".equals(sc_name)) {
			//���request�����Ķ�������sc_name��Ϊ�գ���ͨ��������ȥ���ݿ��в�ѯ����������Ӧ��id
			SecondCategory sc = CategoryService.getInstance().getSecondCategoryByName(sc_name);
			sc_id = sc.getSc_id();
		}
		//���ݶ�����id�����ݿ��ѯ�ö�����������������Ʒ
		List<Product> proList = ProductService.getInstance().searchProductBySc(sc_id,pageNum);
		int pageCount=ProductService.getInstance().searchScProPageCount(sc_id);
		//��ȡ����һ����������select�б�
		List<FirstCategory> fcList=CategoryService.getInstance().searchAllFc();
		//��������id��ҳ�����session�����ڷ�ҳ
		request.setAttribute("fcList", fcList);	
		request.setAttribute("proList", proList);
		request.setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("scId", sc_id);
		request.getSession().setAttribute("pageNumScPro", pageNum);
		request.getRequestDispatcher("/SecondCategory/SearchScProduct.jsp").forward(request, response);
	}

}
