package com.sapient.newsservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.newsservice.model.NewsData;
import com.sapient.newsservice.service.NewsService;


@RestController
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	

	@RequestMapping(value="/headlines", method = RequestMethod.POST)
	public NewsData fetchNews(@RequestParam String country, @RequestParam String category, @RequestParam String keyword) {
		NewsData news = newsService.fetchHeadlines(country,category,keyword);
		return news;
	}

}
