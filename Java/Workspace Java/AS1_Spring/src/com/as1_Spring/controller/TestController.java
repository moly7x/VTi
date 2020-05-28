//
package com.as1_Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 28/05/2020
 */
@Controller
public class TestController {
	@RequestMapping("/test/hello")
	public String helloWorld() {
		return "hello"; // -> Web-INF/view/hello.jsp
	}
}
