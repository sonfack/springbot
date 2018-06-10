package vn.edu.ifi.bot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Chat {

	@RequestMapping("/")
	public String welcome() {
		
		return "index"; 
	}
	
	
}
