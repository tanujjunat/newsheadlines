package com.sapient.newsservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.newsservice.client.NewsServiceClient;
import com.sapient.newsservice.model.NewsData;
import com.sapient.newsservice.service.NewsService;
import com.sapient.newsservice.util.NewsServiceUtil;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsServiceUtil newsServiceUtil;
	
	@Autowired
	private NewsServiceClient newsServiceClient;
	
	@Override
	public NewsData fetchHeadlines(String country, String category, String keyword) {
		
		return newsServiceUtil.convertStringResponseToObject(newsServiceClient.getNewsHeadlines(country,category,keyword));
		
	}

}
