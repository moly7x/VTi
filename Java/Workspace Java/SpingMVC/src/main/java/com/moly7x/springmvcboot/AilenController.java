//
package com.moly7x.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moly7x.springmvcboot.model.Ailen;

@RestController
@RequestMapping("api")
public class AilenController {

	@Autowired
	AilenRepo repo;

	@GetMapping(path = "ailens", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Ailen> getAilens() {

		List<Ailen> ailens = repo.findAll();
		int i = 9/0;
		
		return ailens;
	}
	
	@GetMapping("ailen/{aid}")
	public Ailen getAilen(@PathVariable("aid") int aid) {

		Ailen ailen = repo.findById(aid).orElse(new Ailen (0, ""));

		return ailen;
	}
	
	@RequestMapping(path = "ailen", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, consumes = {"application/xml"})
	public Ailen addAilen(@RequestBody Ailen ailen) {

		repo.save(ailen);

		return ailen;
	}
}
