package com.neuedu.entity;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3046878102687727422L;
	private int id;
	private int parent_id;
	private String name;
	private String status;
	private String sort_order;
	private String create_time;
	private String update_time;
	public Category() {
		super();
	}
	
	public Category(int id, int parent_id, String name, String status, String sort_order, String create_time,
			String update_time) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.status = status;
		this.sort_order = sort_order;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSort_order() {
		return sort_order;
	}
	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	
	
	
	
	
}
