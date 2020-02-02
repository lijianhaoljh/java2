package com.accp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Users;

@RestController
public class LoginController {
	
	@PostMapping("/loginin")
	public Map<String,Object> loginin(String username,String password,HttpSession session){
		Users users = new Users(1,username,password);
		session.setAttribute("user",users);
		Map<String,Object> map = new HashMap<>();
		map.put("user", users);
		map.put("token", session.getId());
		return map;
	}

}
