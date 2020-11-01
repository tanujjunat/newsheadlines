package com.sapient.newsservice.model;

import java.io.Serializable;
import java.util.List;

public class NewsData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4376503048167363598L;
	
	private List<Articles> articles;

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	private String totalResults;
	
	

}
