package com.example.demo.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableCaching//启用缓存
public class RedisCacheConfig  extends CachingConfigurerSupport{




   
}
