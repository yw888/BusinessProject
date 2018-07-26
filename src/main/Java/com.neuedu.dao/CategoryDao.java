package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageMo;


public interface CategoryDao {
	 /**
	  * 添加类别
	  * */
	boolean  addCategory(Category category);
	/**
	 * 查看类别
	 * */
	List<Category> findAll();
	/**
	 * 修改类别
	 * */
	boolean  updateCategory(Category category);
	/**
	 * 删除类别
	 * */
	boolean  deleteCategory(int id);
	
	/**根据id查询商品*/
	Category  findById(int id);
	
	/**
	 * 分页获取数据
	 * pageNo获取第几页
	 * pageSize每页有多少数据
	 * 
	 * */
	public PageMo<Category> findCategoryByPage(int pageNo, int pageSize);
	
}
