package com.ashleybattles.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashleybattles.dojosandninjas.models.Dojo;
import com.ashleybattles.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoServ;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojo/{id}")
	public String dojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("onedojo", dojoServ.getOne(id));
		return "showAll.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		return "createdojo.jsp";
	}
//	
	@PostMapping("/dojos/create")
	public String createDojo(@ModelAttribute("dojo") @Valid Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "createdojo.jsp";
		}else {
			dojoServ.save(dojo);
			return "redirect:/dojos/new";
//			return "redirect:/dojo/" + dojo.getId();
		}
	}
	
	

}
