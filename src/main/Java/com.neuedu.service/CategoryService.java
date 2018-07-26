package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageMo;

public interface CategoryService {

	/**������*/
    public  boolean addCategory(Category category);	
    /**��ѯ���*/
    public  List<Category> findAll();
    /**�޸����*/
    public  boolean  updateCategory(Category category);
    /**ɾ�����*/
    public  boolean deleteCategory(int id);
    /**����id��ѯ�����Ϣ*/
    public  Category findCategoryById(int id);
    /**��ҳ��ȡ*/
    public PageMo<Category> findCategoryByPage(int pageNo, int pageSize);
}
