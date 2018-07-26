package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageMo;
import com.neuedu.utils.DBUtils;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category category) {
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="insert into category(parent_id,name,status,sort_order,create_time,update_time) values (?,?,?,?,?,?)";
			st=conn.prepareStatement(sql);
			//占位符赋值
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time=df.format(new Date());// new Date()为获取当前系统时间
			st.setInt(1, category.getParent_id());
			st.setString(2, category.getName());
			st.setString(3, category.getStatus());
			st.setString(4, category.getSort_order());
			st.setString(5, time);
			st.setString(6, time);
			System.out.println(sql);
			st.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Category> findAll() {
		List<Category> categories=new ArrayList<Category>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="select * from  category";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				
			 int  id= rs.getInt("id");	
			 int  parent_id=rs.getInt("parent_id");
			 String name=rs.getString("name");
			 String status=rs.getString("status");
			 String sort_order=rs.getString("sort_order");
			 String create_time=rs.getString("create_time");
			 String update_time=rs.getString("update_time");
			 Category category=new Category(id,parent_id,name,status,sort_order,create_time,update_time);
			 categories.add(category);
			 
			}
			
			return categories;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time=df.format(new Date());// new Date()为获取当前系统时间
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			//parent_id,name,status,sort_order,create_time,update_time
			String  sql="update category set parent_id=?,name=?,status=?,sort_order=?,update_time=? where id=?";
			st=conn.prepareStatement(sql);
			//占位符赋值
			st.setInt(1, category.getParent_id());
			st.setString(2, category.getName());
			st.setString(3, category.getStatus());
			st.setString(4, category.getSort_order());
			//st.setString(5, category.getCreate_time());
			st.setString(5, time);
			st.setInt(6, category.getId());
			System.out.println(sql);
			st.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteCategory(int id) {
		Connection conn=null;
		PreparedStatement st=null; 
		try {
			conn=DBUtils.getConnection();
			
			String  sql="delete from category where id=?";
			st=conn.prepareStatement(sql);
			//占位符赋值
			st.setInt(1, id);
			System.out.println(sql);
			st.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Category findById(int id) {
		Category category=null;
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select * from  category where id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			
			if(rs.first()) {
				 category=new Category();
				 int  _id= rs.getInt("id");	
				 int  parent_id=rs.getInt("parent_id");
				 String name=rs.getString("name");
				 String status=rs.getString("status");
				 String sort_order=rs.getString("sort_order");
				 String create_time=rs.getString("create_time");
				 String update_time=rs.getString("update_time");
				 
				 category.setId(_id);
				 category.setParent_id(parent_id);
				 category.setName(name);
				 category.setStatus(status);
				 category.setSort_order(sort_order);
				 category.setCreate_time(create_time);
				 category.setUpdate_time(update_time);
			}
			
			
			
			return category;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return category;
	}

	@SuppressWarnings("resource")
	@Override
	public PageMo<Category> findCategoryByPage(int pageNo, int pageSize) {
		PageMo<Category> pageMo=new PageMo<Category>();
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select * from  category limit ?,?";
			
			st=conn.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			List<Category> categories=new ArrayList<Category>();
			while(rs.next()) {
				
				Category category=new Category();
				int  _id= rs.getInt("id");	
				 int  parent_id=rs.getInt("parent_id");
				 String name=rs.getString("name");
				 String status=rs.getString("status");
				 String sort_order=rs.getString("sort_order");
				 String create_time=rs.getString("create_time");
				 String update_time=rs.getString("update_time");
				 
				 category.setId(_id);
				 category.setParent_id(parent_id);
				 category.setName(name);
				 category.setStatus(status);
				 category.setSort_order(sort_order);
				 category.setCreate_time(create_time);
				 category.setUpdate_time(update_time);
				 categories.add(category);
                 pageMo.setData(categories);
			}
			pageMo.setCurrentPage(pageNo);
			String totalCount_sql="select count(id) from category";
			st=conn.prepareStatement(totalCount_sql);
			rs=st.executeQuery();
			if(rs.first()) {
				int totalCount=rs.getInt(1);
				int totalPage=((totalCount%pageSize)==0)?(totalCount/pageSize):((totalCount/pageSize)+1);
				pageMo.setTotalPage(totalPage);
			}
			
			
			
			return pageMo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
