package com.sapient.newsservice.service.impl;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.newsservice.client.NewsServiceClient;
import com.sapient.newsservice.model.NewsData;
import com.sapient.newsservice.service.NewsService;
import com.sapient.newsservice.util.NewsServiceUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsServiceImplTest {

	@Mock
	private NewsServiceUtil newsServiceUtil;
	
	@Mock
	private NewsServiceClient newsServiceClient;
	
	@Mock
	private NewsService newsService;
	
	@Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void fetchHeadlines() {
		String serviceData = "{\"status\":\"ok\",\"totalResults\":2,\"articles\":[{\"source\":{\"id\":\"cnbc\",\"name\":\"CNBC\"},\"author\":\"Berkeley Lovelace Jr.\",\"title\":\"Warren Buffett: There's no question a basket of US stocks will do better over time than bonds\",\"description\":\"Berkshire Hathaway's CEO says: \\\"Over time, a bunch of businesses that are earning higher returns on capital are going to beat a bond that's fixed at roughly 3 percent.\\\"\",\"url\":\"https://www.cnbc.com/2018/08/30/warren-buffett-basket-of-us-stocks-to-do-better-over-time-than-bonds.html\",\"urlToImage\":\"https://fm.cnbc.com/applications/cnbc.com/resources/img/editorial/2018/02/26/105028948-_Y2A0304.1910x1000.JPG\",\"publishedAt\":\"2018-08-30T14:56:16Z\"}]}";
		Mockito.when(newsServiceClient.getNewsHeadlines(Mockito.anyString(),Mockito.anyString(),
				Mockito.anyString())).thenReturn(serviceData);
		ObjectMapper ob = new ObjectMapper();
		NewsData news = null;
		try {
			news = ob.readValue(serviceData, NewsData.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mockito.when(newsServiceUtil.convertStringResponseToObject(Mockito.anyString())).thenReturn(news);
		Assert.assertTrue(news.getStatus().equalsIgnoreCase("OK"));
	}
	
	
}
