package com.sapient.newsservice.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.newsservice.model.NewsData;

@Component
public class NewsServiceUtil {
	
		
	public NewsData convertStringResponseToObject(String newsString) {
		// TODO Auto-generated method stub
		ObjectMapper objectM = new ObjectMapper();
		NewsData news= null;
		try {
		
			news = objectM.readValue(newsString, NewsData.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

}
