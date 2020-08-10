//
package com.moly7x.springmvcboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moly7x.springmvcboot.model.Ailen;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 29/07/2020
 */

@Controller
public class HomeController {

	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Ailens");
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("getAilens")
	public String getAilens(Model m) {
		List<Ailen> ailens = Arrays.asList(new Ailen(101, "Moly"), new Ailen(102, "Tun"));
		m.addAttribute("result", ailens);
		
		return "showAilens";
	}

//	@RequestMapping("add")
//	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {
//		
//		int num3 = i + j;
//		m.addAttribute("num3", num3);
//		
//		return "result";
//	}

	@PostMapping("addAilen")
	public String addAilen(@ModelAttribute("a") Ailen a) {
		return "result";
	}
}
