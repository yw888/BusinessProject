package com.neuedu.entity;

import java.util.LinkedHashMap;
import java.util.Map;


public class Cart3 {
	//key:购物项中的书的id。value：购物项
		private Map<String, CartItem> items = new LinkedHashMap<String, CartItem>();
		private int num;//总数量
		private double price;//总计
		public Map<String, CartItem> getItems() {
			return items;
		}
//		public void setItems(Map<String, CartItem> items) {
//			this.items = items;
//		}
		public int getNum() {
			num=0;
			for(Map.Entry<String, CartItem> me:items.entrySet()){
				num+=me.getValue().getNum();
			}
			return num;
		}
//		public void setNum(int num) {
//			this.num = num;
//		}
		public double getPrice() {
			price = 0;
			for(Map.Entry<String, CartItem> me:items.entrySet()){
				price+=me.getValue().getPrice();
			}
			return price;
		}
//		public void setPrice(float price) {
//			this.price = price;
//		}
		/**
		 * 把购买的书籍放入购物车中的items中
		 */
		
		public void addProductCart(Product product){
			//判断买的书之前有没有买过
			if(items.containsKey(""+product.getId())){
			//买过：只是数量加1
				CartItem item = items.get(""+product.getId());
				item.setNum(item.getNum()+1);
			}else{
			//没有买过：创建一个新的购物项，加入到items中
				CartItem item = new CartItem(product);
				item.setNum(1);
				items.put(""+product.getId(), item);
			}
		}
		
}
