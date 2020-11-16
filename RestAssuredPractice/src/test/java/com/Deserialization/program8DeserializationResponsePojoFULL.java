package com.Deserialization;

import java.util.List;

public class program8DeserializationResponsePojoFULL 
{

	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<program8DeserializationResponsePojoDATA> data;
	private program8DeserializationResponsePojoAD ad;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPer_page() {
		return per_page;
	}
	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public List<program8DeserializationResponsePojoDATA> getData() {
		return data;
	}
	public void setData(List<program8DeserializationResponsePojoDATA> data) {
		this.data = data;
	}
	public program8DeserializationResponsePojoAD getAd() {
		return ad;
	}
	public void setAd(program8DeserializationResponsePojoAD ad) {
		this.ad = ad;
	}


}
