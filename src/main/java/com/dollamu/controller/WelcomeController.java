package com.dollamu.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private static Logger log = LoggerFactory.getLogger(WelcomeController.class);

	@RequestMapping("/")
	public String welcome(ModelMap model) {
		log.info("进入欢迎页 controller");
		
		model.put("key", "此处为服务端返回内容。");
		
		model.put("userName", "管理员");
		
		List<String> list = new ArrayList<>();
		list.add("item1");
		list.add("itemA");
		list.add("item2");
		
		model.put("list", list);
		
		return "index";
	}	
}
