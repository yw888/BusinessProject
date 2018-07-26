package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Cart;
import com.neuedu.entity.Cart2;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService2;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CartServiceImpl2;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/view/cart")
public class CartController2 extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 5219505298770907487L;
	CartService2 cService=new CartServiceImpl2();
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String operation=request.getParameter("operation");
		
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				addCart(request,response);
			}else if(operation.equals("2")){
				findAllCart(request, response);
			}else if(operation.equals("3")) {
				updateCart(request,response);
			}else if(operation.equals("4")) {
				deleteCart(request,response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 添加购物车
	 **/
	public void  addCart(HttpServletRequest request,HttpServletResponse response) {
//    	Cart cart=new Cart();
//		int id=0;
//		int productNum=0;
//		Product product=null;
//		boolean result=false;
//		try {
//			id=Integer.parseInt(request.getParameter("id"));
//			Object o=request.getParameter("product");
//			product=(Product)o;
//			productNum=Integer.parseInt(request.getParameter("productNum"));
//			cart.setId(id);
//			cart.setProduct(product);
//			cart.setProductNum(productNum);
//			result= addCart(cart);
//		}catch(NumberFormatException e){
//			e.printStackTrace();
//		}
//		
//		if(result) {
//			System.out.println("已添加到购物车");
//			findAllCart();
//		}else {
//			System.out.println("添加失败");
//		}
		
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		//response.setContentType("text/html;charset=utf-8");
		try {
			ProductService  pService=new ProductServiceImpl();
			Cart cart=new Cart();
			//ProductDao dao = new ProductDao();
			//Product p = dao.findProductByid(Integer.parseInt(id));
			Product p=pService.findProductById(Integer.parseInt(id));
			List<Map<String ,Object>> shoppinglist=(List<Map<String ,Object>>)session.getAttribute("shoppinglist");
			if (shoppinglist == null) {
				shoppinglist = new ArrayList<Map<String ,Object>>();
			}
			boolean isExits=false;
			boolean result=false;
		    for( Map<String ,Object> map:shoppinglist){
		    	if(((Product)map.get("goods")).getId()==Integer.parseInt(id)){
		    		int count=Integer.parseInt((map.get("count").toString()));
		    		count++;
		    		map.put("count", count);
		    		isExits=true;
		    		cart.setId(Integer.parseInt(id));
		    		cart.setProduct(p);
		    		cart.setProductNum(count);
		    		result= addCart(cart);
		    		if(result) {
				    	System.out.println("已添加到购物车");	
				    }else {
				    	System.out.println("添加失败");
				    }
		    		break;
		    	}
		    }
		    if(!isExits){
		    	Map<String, Object> goodsMap = new HashMap<String, Object>();
		    	goodsMap.put("goods", p);
		    	goodsMap.put("count", "1");
		    	shoppinglist.add(goodsMap);
		    	session.setAttribute("shoppinglist", shoppinglist);
		    }
		    response.sendRedirect("car.jsp");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		 
	
	
	public boolean  addCart(Cart cart) {
		
		return cService.addCart(cart);
	}
	/**
	 * 删除
	 * @throws IOException 
	 * */
	public void deleteCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> shoppinglist=(List<Map<String,Object>>)session.getAttribute("shoppinglist");
		  for(int i=0;i<shoppinglist.size();i++){
			  if(((Product)(shoppinglist.get(i).get("goods"))).getId()==Integer.parseInt(id)){
				  shoppinglist.remove(i);
				  break;
			  }
			  
		  }
		  try {
	    		boolean result=cService.deleteCart(Integer.parseInt(id));
	    		if(result) {
	    			response.sendRedirect("car.jsp");
	    		}else {
	    			System.out.println("删除id="+id+"的商品失败");
	    		}
	    	}catch(NumberFormatException e) {
	    		e.printStackTrace();
	    	}
		  
		  
		  
		 
	}
	public boolean  deleteCart(int id) {
		return cService.deleteCart(id);
	}
	/**
	 * 修改购物车
	 * @throws IOException 
	 * */
	public void updateCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> shoppinglist=(List<Map<String,Object>>)session.getAttribute("shoppinglist");
		if (shoppinglist == null) {
			shoppinglist = new ArrayList<Map<String ,Object>>();
		}
		int num=1;
		for( Map<String ,Object> map:shoppinglist){
		    	if(((Product)map.get("goods")).getId()==Integer.parseInt(id)){
		    		int count=Integer.parseInt((map.get("count").toString()));
		    		num=Integer.parseInt(request.getParameter("number"));
		    		System.out.println(num);
		    		count=num;
		    		map.put("count", count);
		    		break;
		    	}
		    }
		  try {
	    		boolean result=cService.updateCart(Integer.parseInt(id),num);
	    		if(result) {
	    			response.sendRedirect("car.jsp");
	    		}else {
	    			System.out.println("修改id="+id+"的商品失败");
	    		}
	    	}catch(NumberFormatException e) {
	    		e.printStackTrace();
	    	}
		
		
		
		
		
		
		
		
		
		
//		
//		String id=request.getParameter("id");
//		System.out.println(id);
//		HttpSession session=request.getSession();
//		try {
//			ProductService  pService=new ProductServiceImpl();
//			Product p=pService.findProductById(Integer.parseInt(id));
//			List<Map<String ,Object>> shoppinglist=(List<Map<String ,Object>>)session.getAttribute("shoppinglist");
//			if (shoppinglist == null) {
//				shoppinglist = new ArrayList<Map<String ,Object>>();
//			}
//			boolean isExits=false;
//		    for( Map<String ,Object> map:shoppinglist){
//		    	if(((Product)map.get("goods")).getId()==Integer.parseInt(id)){
//		    		int count=Integer.parseInt((map.get("count").toString()));
//		    		int num=Integer.parseInt(request.getParameter("number"));
//		    		System.out.println(num);
//		    		count=num;
//		    		map.put("count", count);
//		    		isExits=true;
//		    		break;
//		    	}
//		    }
//		    if(!isExits){
//		    	Map<String, Object> goodsMap = new HashMap<String, Object>();
//		    	goodsMap.put("goods", p);
//		    	goodsMap.put("count", "1");
//		    	shoppinglist.add(goodsMap);
//		    	session.setAttribute("shoppinglist", shoppinglist);
//		    }
//		    response.sendRedirect("car.jsp");
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public boolean  updataeCart(Cart cart) {
		return false;
	}
	/**
	 * 查询购物车
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	public void findAllCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo=request.getParameter("pageNo");
    	String pageSize=request.getParameter("pageSize");
    	int _pageNo=1;
    	int _pageSize=5;
    	try {
    		if(pageNo!=null&&pageSize!=null) {
    			_pageNo=Integer.parseInt(pageNo);
    			_pageSize=Integer.parseInt(pageSize);
    		}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	PageMo<Cart2> pageMo=cService.findCartByPage(_pageNo, _pageSize);
    	
    	request.setAttribute("pageMo",pageMo);
    	request.getRequestDispatcher("showcartbypage.jsp").forward(request, response);
    	
	}
	public List<Cart> findAllCart(){
		return cService.findAllCart();
	}
	/**
	 * 获取购物车中商品数量
	 * */
	public int  getCartNum() {
		return cService.getCartNum();
	};
	
	/**修改购物车商品数量
	 * @param  id  要修改的购物车的Id
	 * @param  num 修改后的数量
	 * */
	public boolean  updateCart(int id,int num) {
		return  cService.updateCart(id, num);
	};
}
