package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageMo;


public interface CategoryDao {
	 /**
	  * ������
	  * */
	boolean  addCategory(Category category);
	/**
	 * �鿴���
	 * */
	List<Category> findAll();
	/**
	 * �޸����
	 * */
	boolean  updateCategory(Category category);
	/**
	 * ɾ�����
	 * */
	boolean  deleteCategory(int id);
	
	/**����id��ѯ��Ʒ*/
	Category  findById(int id);
	
	/**
	 * ��ҳ��ȡ����
	 * pageNo��ȡ�ڼ�ҳ
	 * pageSizeÿҳ�ж�������
	 * 
	 * */
	public PageMo<Category> findCategoryByPage(int pageNo, int pageSize);
	
}
