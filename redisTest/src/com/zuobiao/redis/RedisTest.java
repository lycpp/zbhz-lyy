package com.zuobiao.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class RedisTest {
	static  Jedis js = new Jedis("192.168.0.133", 6379);
	static int i = 3;
	
	public static void main(String[] args) {
		js.auth("a12345");
		
		System.out.println(js.zrange("经验",0,-1));
		Set<Tuple> zrange = js.zrangeWithScores("经验",0,-1);
		for (Tuple tuple : zrange) {
			String element = tuple.getElement();
			
			System.out.println(element+":"+ tuple.getScore());
		}
		System.out.println("-----------------------");
		js.zincrby("经验",i,"李海宽");
	
		Set<Tuple> zrange1 = js.zrangeWithScores("经验",0,-1);
		for (Tuple tuple : zrange1) {
			String element = tuple.getElement();
			
			System.out.println(element+":"+ tuple.getScore());
		}
	
		
	}
	
}
