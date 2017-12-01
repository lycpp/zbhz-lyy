package com.example.demo.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ResultBean;
import com.example.demo.service.ArticleService;

import redis.clients.jedis.Jedis;
@Service
public class ArticleServiceImpl implements ArticleService{

	private Map<String, String> hgetAll;

	@Override
	public ResultBean ding(String title) {
	 Jedis js = new Jedis("192.168.0.133", 6379);
	 js.auth("a12345");
	 //此处应调用赞自增的方法
	
	 js.hincrBy(title,"voteup", 1);//每次运行在赞的记录上增加1;
	 hgetAll = js.hgetAll(title);
	
	 
	 js.close();
			
			
		
		return new ResultBean(title, hgetAll.get("voteup"), hgetAll.get("votedown"));
	}

}
