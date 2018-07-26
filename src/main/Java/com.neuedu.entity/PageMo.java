package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

public class PageMo<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3513258403828844170L;
	private List<T> data;
	private int totalPage;
	private int currentPage;
	
	public PageMo() {
		super();
	}
	public PageMo(List<T> data, int totalPage, int currentPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
