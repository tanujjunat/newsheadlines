package com.sapient.newsservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;


public class Articles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4376503048167363588L;
	
	private String author;
	
	public String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Source source;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		
		String shortDesc = description; 
	 
		if(!StringUtils.isEmpty(description)){
		 shortDesc = Stream.of(description.split(" ")).limit(100).collect(Collectors.joining(" "));
		 
		 if(!shortDesc.equalsIgnoreCase(description))
			 shortDesc += "...";
		} 
	 
		return shortDesc;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String title;
	
	public String description;
	
	public String url;
	
	public String urlToImage;
	
	public Date publishedAt;
	
	

}
