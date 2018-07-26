package com.neuedu.controller.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * Servlet implementation class FrontLoginController
 */
@WebServlet("/FrontLoginController")
public class FrontLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILoginService  loginService=new LoginServiceImpl();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String method=request.getParameter("method");
		Account acc=loginService.doLogin(username,MD5Utils.GetMD5Code(password));
		if(acc!=null){//登录成功
//			StringBuffer sbuffer=new StringBuffer("{");
//			//用户名
//			sbuffer.append("\"");
//			sbuffer.append("username");
//			sbuffer.append("\"");
//			sbuffer.append(":");
//			sbuffer.append("\"");
//			sbuffer.append(acc.getUsername());
//			sbuffer.append("\"");
//			sbuffer.append(",");
//			
//			//密码
//			sbuffer.append("\"");
//			sbuffer.append("password");
//			sbuffer.append("\"");
//			sbuffer.append(":");
//			sbuffer.append("\"");
//			sbuffer.append(acc.getPassword());
//			sbuffer.append("\"");
//			sbuffer.append(",");
//			
//			//ip
//			sbuffer.append("\"");
//			sbuffer.append("ip");
//			sbuffer.append("\"");
//			sbuffer.append(":");
//			sbuffer.append("\"");
//			sbuffer.append(acc.getIp());
//			sbuffer.append("\"");
//			sbuffer.append(",");
//			
//			//sex
//			sbuffer.append("\"");
//			sbuffer.append("sex");
//			sbuffer.append("\"");
//			sbuffer.append(":");
//			sbuffer.append("\"");
//			sbuffer.append(acc.getSex());
//			sbuffer.append("\"");
//			
//			
//			sbuffer.append("}");
//			
//			System.out.println(sbuffer.toString());
			//gson jsr--->google
			//jackson.jar--->alibaba
			//将java对象转成json字符串
			Gson gson=new Gson();
			String json=gson.toJson(acc);
			//将json字符串--->java对象
			Account account=gson.fromJson(json, Account.class);
			System.out.println(account);
			//获取输出流
			PrintWriter write=response.getWriter();
			//success
			write.println(method+"("+json+")");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
