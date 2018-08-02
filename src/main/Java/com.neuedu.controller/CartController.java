package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		String operation=request.getParameter("operation");
		if (operation!=null&&!operation.equals("")){
			if (operation.equals("1")){
				findCart(request,response);
			}else if(operation.equals("2")){
				addCart(request , response);
			}
		}

//		String method = request.getParameter("method");
//		if("addCart".equalsIgnoreCase(method)) {
//			addCart(request , response);
//		} else if("findAll".equalsIgnoreCase(method)) {
//			findAll(request , response);
//		}else if("getMsgByPage".equalsIgnoreCase(method)) {
//			//getMsgByPage(request ,response);
//		}
	}



  CartService cartService=new CartServiceImpl();
	
	/**
	 * ��ӹ��ﳵ
	 **/
	public  void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart=new Cart();
		int productid=0;
		int productnum=0;
		boolean result=false;
		try {
			productid=Integer.parseInt(req.getParameter("pid"));
			productnum=Integer.parseInt(req.getParameter("productnum"));
			ProductController  productController=new ProductController();
			Product product= productController.findProductById(productid);
			cart.setProduct(product);
			cart.setProductNum(productnum);
			result= addCart(cart);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(result) {
			System.out.println("���ﳵ��ӳɹ�");
//			findCartByPage(req, resp);
			findCart(req, resp);

		}else {
			System.out.println("���ﳵ���ʧ��");
		}

	}
	public boolean  addCart(Cart cart) {
		
		return cartService.addCart(cart);
	}
	/**
	 * ɾ��
	 * */
	public boolean  deleteCart(int id) {
		return cartService.deleteCart(id);
	}
	/**
	 * �޸Ĺ��ﳵ
	 * */
	public boolean  updataeCart(Cart cart) {
		return false;
	}
	/**
	 * ��ѯ���ﳵ
	 * */
	public void findCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<Cart> cartList=findAllCart();
		String callback=request.getParameter("callback");
		Gson gson=new Gson();
		String json=gson.toJson(cartList);
		PrintWriter printWriter=response.getWriter();
		printWriter.write(callback+"("+json+")");
	}
	public  void findAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		List<Cart> carts= cartService.findAllCart();
		System.out.println(carts);
//	String info=JSONArray.toJSONString(carts);
//	resp.getWriter().print(info);
//		req.setAttribute("carts", carts);
//		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}
	public List<Cart> findAllCart(){
		return cartService.findAllCart();
	}
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	public int  getCartNum() {
		return cartService.getCartNum();
	};
	
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵĹ��ﳵ��Id
	 * @param  num �޸ĺ������
	 * */
	public boolean  updateCart(int id,int num) {
		return  cartService.updateCart(id, num);
	};
}
