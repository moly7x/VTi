//
package com.moly7x.springmvcnoboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moly7x.springmvcnoboot.dao.AilenDAO;
import com.moly7x.springmvcnoboot.model.Ailen;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 29/07/2020
 */

@Controller
public class HomeController {

	@Autowired
	AilenDAO dao;

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
		m.addAttribute("result", dao.getAilens());
		
		return "showAilens";
	}
	
	@GetMapping("getAilen")
	public String getAilen(@RequestParam int aid , Model m) {
		
		m.addAttribute("result", dao.getAilen(aid));
		return "showAilens";
	}

	@RequestMapping("addAilen")
	public String addAilen(@ModelAttribute("result") Ailen a) {
		dao.addAilens(a);
		return "showAilens";
	}
}
