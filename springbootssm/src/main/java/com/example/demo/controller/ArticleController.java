package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultBean;
import com.example.demo.service.ArticleService;

@RestController
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="ding")
	@ResponseBody
	public String ding(String name,Model model) {
		System.out.println(name);
		
		ResultBean rb=articleService.ding(name);
		
		
		
		model.addAttribute("resultbean", rb);
		return name;
	}
	@RequestMapping(value="cai")
	@ResponseBody
	public String cai(String title) {
			System.out.println("踩一下");
		return "voteup:192,votedown:22";
	}
}
