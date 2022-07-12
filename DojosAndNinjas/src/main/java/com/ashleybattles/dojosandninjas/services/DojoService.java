package com.ashleybattles.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashleybattles.dojosandninjas.models.Dojo;
import com.ashleybattles.dojosandninjas.repo.DojoRepo;

@Service
public class DojoService {
	
//add in CRUD
	@Autowired
	private DojoRepo dojoRepo;
	
	//CREATE &&&&&& //UPDATE
	
	public Dojo save(Dojo d) {
		return dojoRepo.save(d);
	}
	
	//READ
	public List<Dojo> getAll(){
		return dojoRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		if(optDojo.isPresent()) {
			return optDojo.get();
		}else {
			return null;
		}
	}
	
	
	//DELETE
	
	public void delete(Long id) {
		dojoRepo.deleteById(id);
	}

}
