package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Cart3;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/BuyServlet")
//������Ʒ
public class BuyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5418232660616710712L;
	private ProductService s = new ProductServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = s.findProductById(productId);
		//���ĺ��ѵ㣺���빺�ﳵ
		HttpSession session = request.getSession();
		Cart3 cart = (Cart3)session.getAttribute("cart");
		if(cart==null){
			cart = new Cart3();
			session.setAttribute("cart",cart);
		}
		s.addProduct2Cart(cart,product);//���빺�ﳵ��ͨ��ҵ�������
		
		out.write("["+product.getName()+"]�Ѿ��������Ĺ��ﳵ��<a href='"+"http://localhost:8080/BusinessProject_Web/ProductPageController?pageNo=1"+"'>��������</a>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
