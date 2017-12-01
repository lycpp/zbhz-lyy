package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;

@Controller

public class UserController {
	private Workbook wb;
//	protected static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserMapper userMapper;

	@RequestMapping(value = "cs")
	public User cs(Model model) {
		// 调用dao层
		User user = userMapper.selectUserByName("beyondLi");
		model.addAttribute("user", user);

		return user;
	}

	@RequestMapping(value = "cs2")
	public String cs2(@RequestParam("file") MultipartFile file) throws Exception {

		long startTime = System.currentTimeMillis();
		System.out.println("fileName：" + file.getOriginalFilename());

		try {
			// 获取输出流
			OutputStream os = new FileOutputStream("E:/" + new Date().getTime() + file.getOriginalFilename());
			// 获取输入流 CommonsMultipartFile 中可以直接得到文件的流
			InputStream is = file.getInputStream();
			int temp;
			// 一个一个字节的读取并写入
			while ((temp = is.read()) != (-1)) {
				os.write(temp);
			}
			os.flush();
			os.close();
			is.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法一的运行时间：" + String.valueOf(endTime - startTime) + "ms");
		return "success";
	}

	@RequestMapping(value = "cs3")
	public String cs3(@RequestParam("file") MultipartFile file) throws Exception {
	
			InputStream is = file.getInputStream();

			String fileName = file.getOriginalFilename();

			if (fileName.endsWith(".xls")) {
				// 老版本
				wb = new HSSFWorkbook(is);
				System.out.println("aaaa");
			} else if (fileName.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(is);
				System.out.println("hahahah");
			}
			/*//标题总列数
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(0);
			int colNum = row.getPhysicalNumberOfCells(); 
			String[] title = new String[colNum];  
			for (int i = 0; i < colNum; i++) {  
				// title[i] = getStringCellValue(row.getCell((short) i));  
				title[i] = row.getCell(i).getCellFormula();  
				System.out.println(title[i]);
			}  
*/
		

		return "success"; 
	}


}