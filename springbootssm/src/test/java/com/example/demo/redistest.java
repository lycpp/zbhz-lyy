package com.example.demo;

import redis.clients.jedis.Jedis;

public class redistest {
	public static void main(String[] args) {
		//注意关防火墙
		Jedis js= new Jedis("192.168.0.133", 6379,100000);
		js.auth("a12345");
		js.set("a", "123");
		System.out.println(js.get("a"));
	}
}
