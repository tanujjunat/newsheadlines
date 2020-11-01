package com.sapient.newsservice.client;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sapient.newsservice.constants.NewsConstants;

@Component
public class NewsServiceClient {
	
	public String getNewsHeadlines(String country, String category, String keyword) {
		HttpResponse<String> jsonResponse = null;
		String newsData = null;
		String url = String.format(NewsConstants.NEWS_WEB_SERVICE_URL, country, category);
		
		if(StringUtils.isNotEmpty(keyword))
			url += NewsConstants.AND_Q + keyword;
		
	    		
		try {
			jsonResponse = Unirest.get(url)
			.header(NewsConstants.CONTENT_TYPE_KEY, NewsConstants.CONTENT_TYPE_JSON)
			.header(NewsConstants.CACHE_CONTROL, NewsConstants.NO_CACHE).asString();			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (jsonResponse.getStatus() == 200) {
			newsData = jsonResponse.getBody();
		}
		
		return newsData;
	}

	}
