package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DelAllCartItemServlet")
public class DelAllCartItemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6526346728796649284L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getSession().invalidate();
		request.getSession().removeAttribute("cart");
		//转发到显示购物车的页面
		request.getRequestDispatcher("/view/showCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
