package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Cart3;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/ChangeNumServlet")
//�޸Ĺ����������
public class ChangeNumServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3578961237673383285L;
	private ProductService s = new ProductServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String  productId =request.getParameter("productId");
			String newnum = request.getParameter("newnum");
			System.out.println(productId+"==========");
			//�ҳ����ﳵ
			Cart3 cart = (Cart3)request.getSession().getAttribute("cart");
			
			System.out.println(cart+"=========");
			int num = Integer.parseInt(newnum);
			if(num<1){
				request.setAttribute("message","<script type='text/javascript'>alert('��������ȷ������ֵ');</script>" );
			}else{
			//�޸�����
			s.changeCartItemNum(productId,cart,num);
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message","<script type='text/javascript'>alert('��������ȷ������');</script>" );
		}
		//ת������ʾ���ﳵ��ҳ��
		request.getRequestDispatcher("/view/showCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
