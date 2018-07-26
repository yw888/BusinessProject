package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.CartDao2;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Cart2;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class CartDaoImpl2 implements CartDao2 {

	ProductDao productDao=new ProductDaoImpl();
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="insert into cart(productid,productnum) values ("+cart.getProduct().getId()+","+cart.getProductNum()+")";
			System.out.println(sql);
			st.execute(sql);
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
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="delete from cart where id="+id+"";
			System.out.println(sql);
			st.execute(sql);
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
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="update cart set productnum="+cart.getProductNum()+"where id="+cart.getId()+"";
			System.out.println(sql);
			st.execute(sql);
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
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		
	List<Cart> carts=new ArrayList<Cart>();
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="select id,productid,productnum from  cart";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 int  productid=rs.getInt("productid");
			 int num=rs.getInt("productnum");
			 
			 
			 Cart cart=new Cart();
			 cart.setId(id);
			 cart.setProductNum(num);
			 
			 cart.setProduct(productDao.findById(productid));
			 
			 
			 
			 
			 carts.add(cart);
			 
			 
			}
			
			return carts;
			
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
	public int getCartNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="update cart set productnum="+num+" where id="+id+"";
			System.out.println(sql);
			st.execute(sql);
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
	public void clearCart() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("resource")
	@Override
	public PageMo<Cart2> findCartByPage(int pageNo, int pageSize) {
		PageMo<Cart2> pageMo=new PageMo<Cart2>();
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select * from  cart limit ?,?";
			
			st=conn.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			List<Cart2> carts=new ArrayList<Cart2>();
			while(rs.next()) {
				
				Cart2 cart=new Cart2();
				 int  _id= rs.getInt("id");	
				 int  productid=rs.getInt("productid");
				 int  productnum=rs.getInt("productnum");
				 Product product=new Product();
				 product.setId(productid);
				 cart.setId(_id);
				 cart.setProduct(product);
				 cart.setProductNum(productnum);
				 carts.add(cart);
                 pageMo.setData(carts);
			}
			pageMo.setCurrentPage(pageNo);
			String totalCount_sql="select count(id) from cart";
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
