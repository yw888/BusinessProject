package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
@WebFilter("/view/*")
public class CheckLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("=======到达k过滤器");
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
		HttpSession session=_request.getSession();
		Object o=session.getAttribute("token");
		Object accobj=session.getAttribute("acc");
		if(o!=null&&accobj!=null) {
			String token=(String)o;
			Account acc=(Account)accobj;
			ILoginService loginServic=new LoginServiceImpl();
			String result_token=loginServic.findTokenByAccountid(acc.accountId);
			if(result_token!=null) {
				if(token.equals(result_token)){
					//有效的token
					chain.doFilter(request, response);
					return;
				}
			}
			
		}
		//页面跳转的第二种方式：重定向
		_response.sendRedirect("http://localhost:8080/BusinessProject_Web/login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
