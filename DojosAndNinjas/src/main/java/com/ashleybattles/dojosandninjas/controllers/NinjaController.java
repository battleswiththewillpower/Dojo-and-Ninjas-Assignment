package com.ashleybattles.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashleybattles.dojosandninjas.models.Dojo;
import com.ashleybattles.dojosandninjas.models.Ninja;
import com.ashleybattles.dojosandninjas.services.DojoService;
import com.ashleybattles.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaServ;
	
	@Autowired
	private DojoService dojoServ;
	
	@GetMapping("/ninjas")
	public String index() {
//		return "createninja.jsp";
		return "redirect:/ninjas/new";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model ) {
		model.addAttribute("dojos", dojoServ.getAll());
		return "createninja.jsp";
	}
	
	@PostMapping("/ninja/create")
	public String createninja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("dojos", dojoServ.getAll());
			return "createninja.jsp";
		}else {
//			System.out.println(ninja.getFirstName());
//			System.out.println(ninja.getLastName());
//			System.out.println(ninja.getAge());
			System.out.println(ninja.getDojo());
			ninjaServ.save(ninja);
			Dojo dojo = ninja.getDojo();
//			System.out.println(ninja);
			return "redirect:/dojo/" + dojo.getId();
		}
	}
	
	

}
