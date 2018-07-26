package com.neuedu.entity;

import java.util.LinkedHashMap;
import java.util.Map;


public class Cart3 {
	//key:�������е����id��value��������
		private Map<String, CartItem> items = new LinkedHashMap<String, CartItem>();
		private int num;//������
		private double price;//�ܼ�
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
		 * �ѹ�����鼮���빺�ﳵ�е�items��
		 */
		
		public void addProductCart(Product product){
			//�ж������֮ǰ��û�����
			if(items.containsKey(""+product.getId())){
			//�����ֻ��������1
				CartItem item = items.get(""+product.getId());
				item.setNum(item.getNum()+1);
			}else{
			//û�����������һ���µĹ�������뵽items��
				CartItem item = new CartItem(product);
				item.setNum(1);
				items.put(""+product.getId(), item);
			}
		}
		
}
