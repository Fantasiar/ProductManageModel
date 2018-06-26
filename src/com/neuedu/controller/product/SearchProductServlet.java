package com.neuedu.controller.product;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SearchProductServlet
 */
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
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
		//��servlet���ڲ�ѯ��Ʒ
		
		//�������ı���
		request.setCharacterEncoding("utf-8");
		//���ݲ�ͬ��actionִ�в�ͬ�Ĳ���
		String action = request.getParameter("action");
		//��ȡ��ǰҳ��
		String currentPageNumber = request.getParameter("pageNumPro");
		int pageNum=1;
		int product_id=0;
		
		List<Product> proList = new ArrayList<Product>();
		int pageCount=0;
		if ("blank".equals(action)) {
			//�����״ε�������ѯ��Ʒ���棬ϵͳ��Ĭ�ϲ�ѯ��������Ʒ�б������з�ҳչʾ
				proList = ProductService.getInstance().findAllPageProduct(pageNum);
				pageCount=ProductService.getInstance().findAllPageCount();
				//������Ʒ�б�������Ʒ�ڶ����е�״̬��Ϊÿ����Ʒ�������Ƿ��ɾ��������
				for (Product pro : proList) {
					int pro_id = pro.getProduct_id();
					boolean isDelete=ProductService.getInstance().checkProDelete(pro_id);
					pro.setDelete(isDelete);
				}
				
		}else {
			//���ڷǵ�һ�ν�����Ʒ��ѯ�������������������ҳ��������Ʒ�����в�ѯ��
			String product_name=request.getParameter("product_name");
			product_id = ProductService.getInstance().searchProductIdByName(product_name);
			if (product_id != 0) {
				//session�д������Ʒid�����ݣ���ִ�и�����Ʒ����ѯ��Ʒ�Ĳ���
				if (currentPageNumber != null && !"".equals(currentPageNumber )) {
					//�����ǰҳ�벻����pageNum�����޸�pageNum��ֵΪ��ǰҳ��
					pageNum=Integer.parseInt(currentPageNumber);
				}
					//������Ʒid��ѯ��Ӧ����Ʒ
					proList = ProductService.getInstance().findProductByName(product_id,pageNum);
					pageCount=ProductService.getInstance().findProductPageCount(product_id);
					//������Ʒ�б�������Ʒ�ڶ����е�״̬��Ϊÿ����Ʒ�������Ƿ��ɾ��������
					for (Product pro : proList) {
						int pro_id = pro.getProduct_id();
						boolean isDelete=ProductService.getInstance().checkProDelete(pro_id);
						pro.setDelete(isDelete);
					}
				
			}else {
				//session��û�д����Ʒid�����ݣ���Ĭ��Ϊ��ѯ������Ʒ�ķ�ҳ����
				if (currentPageNumber != null && !"".equals(currentPageNumber)) {
					pageNum=Integer.parseInt(currentPageNumber);
				}
				//��ѯ�����������Ʒ���б�
				proList = ProductService.getInstance().findAllPageProduct(pageNum);
				pageCount=ProductService.getInstance().findAllPageCount();
				//������Ʒ�б�������Ʒ�ڶ����е�״̬��Ϊÿ����Ʒ�������Ƿ��ɾ��������
				for (Product pro : proList) {
					int pro_id = pro.getProduct_id();
					boolean isDelete=ProductService.getInstance().checkProDelete(pro_id);
					pro.setDelete(isDelete);
				}
			}
			
		}
		//����Ʒid��ҳ�����session�����ڷ�ҳ
		request.getSession().setAttribute("product_id", product_id);
		request.setAttribute("proList", proList);	
		request.setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("pageNumPro", pageNum);
		request.getRequestDispatcher("/Product/SearchProduct.jsp").forward(request, response);
	}

}
