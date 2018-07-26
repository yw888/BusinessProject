package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ShowCartServlet")
//ת������ʾ���ﳵ��ҳ��
public class ShowCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1039483722019534595L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ֱ��ת����ʾ���ﳵ��ҳ�漴��
		request.getRequestDispatcher("/view/showCart.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
