package com.sapient.newsservice.service;


import com.sapient.newsservice.model.NewsData;

public interface NewsService {

	public NewsData fetchHeadlines(String country, String category, String keyword);
}
