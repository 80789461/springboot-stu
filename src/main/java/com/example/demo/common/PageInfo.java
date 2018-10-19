package com.example.demo.common;

public class PageInfo {
	/**
	 * 当前页
	 */
	private int currentPage; 

	/**
	 * 显示多少条
	 */
	private int pageSize;

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	
	public PageInfo(int currentPage,int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
}
