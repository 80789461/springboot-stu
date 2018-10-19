package com.example.demo.common;
public class PageAble<T> {
	private  PageInfo page;
	private long totalCount;
	private int pageSize;
	private int currentPage;
	private  T datas;
	public PageAble(T data,PageInfo page,long totalCount){
		this.page = page;
		this.totalCount = totalCount;
		this.pageSize=page.getPageSize();
		this.currentPage = page.getCurrentPage();
		this.datas=data;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public T getDatas() {
		return datas;
	}
}
