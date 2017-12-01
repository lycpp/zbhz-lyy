package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@EnableTransactionManagement//开启事务管理
//@MapperScan("com.example.sboot.dao")//与dao层的@Mapper二选一写上即可(主要作用是扫包)
@RestController
@SpringBootApplication
public class SpringbootssmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootssmApplication.class, args);
	}
	
	@RequestMapping("/")
	public String  index() {
		System.out.println("hah");
		return "haha";
		
	}
	
}
 