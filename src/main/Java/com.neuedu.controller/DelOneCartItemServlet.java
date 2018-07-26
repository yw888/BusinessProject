package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Cart3;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/DelOneCartItemServlet")
//删除一个购物项
public class DelOneCartItemServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -483459315653469904L;
	private ProductService s = new ProductServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId =request.getParameter("productId");
		HttpSession session = request.getSession();
		
		Cart3 cart = (Cart3)session.getAttribute("cart");
		if(cart==null){
			cart = new Cart3();
			session.setAttribute("cart", cart);
		}
		System.out.println("这是"+productId);
		System.out.println("这是"+cart);
		s.delOneItem(cart,productId);
		//转发到显示购物车的页面
		request.getRequestDispatcher("/view/showCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
