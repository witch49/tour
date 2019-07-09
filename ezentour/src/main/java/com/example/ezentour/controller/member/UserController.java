package com.example.ezentour.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "mypage/user/main")
	public String home() {		
		return "user/mypage/user_home";
	}
	
	@RequestMapping(value = "mypage/user/mycart")
	public String myCart() {		
		return "user/mypage/mycart";
	}
}