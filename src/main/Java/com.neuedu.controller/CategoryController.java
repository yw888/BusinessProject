package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageMo;
import com.neuedu.service.CategoryService;
import com.neuedu.service.impl.CategoryServiceImpl;


@WebServlet("/view/category")
public class CategoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6523957518066320854L;
	CategoryService  cService=new CategoryServiceImpl();
			
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		String operation=request.getParameter("operation");
		
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				addCategory(request,response);
			}else if(operation.equals("2")){
				findAll(request, response);
			}else if(operation.equals("3")) {
				updateCategory(request,response);
			}else if(operation.equals("4")) {
				deleteCategory(request,response);
			}else if(operation.equals("5")) {
				//查询单个
				findById(request,response);
			}
		}
		
		
	}
	private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cid=request.getParameter("id");
    	
    	int id=0;
    	try {
    		id=Integer.parseInt(cid);
    		Category category=findById(id);
    		if(category!=null) {
    			//查询成功
    			request.setAttribute("category", category);
    			request.getRequestDispatcher("updatecategory.jsp").forward(request, response);
    		}else {
    			System.out.println("删除id="+id+"的类别失败");
    		}
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
		
	}
	
	private Category findById(int id) {
		
		return cService.findCategoryById(id);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void addCategory(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Category category=new Category();
		
		String name=request.getParameter("cname");
		String status=request.getParameter("cstatus");
		String sort_order=request.getParameter("csort_order");
		//String create_time=request.getParameter("ccreate_time");
		//String update_time=request.getParameter("cupdate_time");
		int parent_id=0;
		boolean result=false;
		try {
			parent_id=Integer.parseInt(request.getParameter("cparent_id"));
			category.setParent_id(parent_id);
			category.setName(name);
			category.setStatus(status);
			category.setSort_order(sort_order);
			//category.setCreate_time(create_time);
			//category.setUpdate_time(update_time);
			result= addCategory(category);
			
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("类别添加成功");
			findAll(request,response);
			
		}else {
			System.out.println("类别添加失败");
		}
	
	}
	
	/**添加商品*/
    public  boolean addCategory(Category category) {
    	return cService.addCategory(category);
    }	
    /**查询类别
     * @throws IOException 
     * @throws ServletException */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String pageNo=request.getParameter("pageNo");
    	String pageSize=request.getParameter("pageSize");
    	int _pageNo=1;
    	int _pageSize=4;
    	try {
    		if(pageNo!=null&&pageSize!=null) {
    			_pageNo=Integer.parseInt(pageNo);
    			_pageSize=Integer.parseInt(pageSize);
    		}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	PageMo<Category> pageMo=cService.findCategoryByPage(_pageNo,_pageSize);
    	System.out.println(_pageNo+":"+_pageSize);
    	request.setAttribute("pageMo",pageMo);
    	request.getRequestDispatcher("showcategorytbypage.jsp").forward(request, response);
    	
    }
    
    public void updateCategory(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

    	Category category=new Category();
		
    	String name=request.getParameter("cname");
		String status=request.getParameter("cstatus");
		String sort_order=request.getParameter("csort_order");
		//String create_time=request.getParameter("ccreate_time");
		//String update_time=request.getParameter("cupdate_time");
		int parent_id=0;
		int id=0;
		
		boolean result=false;
		try {
			parent_id=Integer.parseInt(request.getParameter("cparent_id"));
			id=Integer.parseInt(request.getParameter("id"));
			category.setId(id);
			category.setParent_id(parent_id);
			category.setName(name);
			category.setStatus(status);
			category.setSort_order(sort_order);
			//category.setCreate_time(create_time);
			//category.setUpdate_time(update_time);
			result= updateCategory(category);
			
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		
		if(result) {
			System.out.println("类别修改成功");
			findAll(request, response);
			
		}else {
			System.out.println("类别修改失败");
		}
    	
    }
    
    /**修改商品*/
    public  boolean  updateCategory(Category category) {
    	return cService.updateCategory(category);
    }
    /**删除商品
     * @throws IOException 
     * @throws ServletException */
    public  void deleteCategory(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	
    	String cid=request.getParameter("id");
    	
    	int id=0;
    	try {
    		id=Integer.parseInt(cid);
    		boolean result=cService.deleteCategory(id);
    		if(result) {
    			findAll(request, response);
    		}else {
    			System.out.println("删除id="+id+"的类别失败");
    		}
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	
    	return;
    }
    public Category findCategoryById(int id) {
    	return cService.findCategoryById(id);
    }

	
}
