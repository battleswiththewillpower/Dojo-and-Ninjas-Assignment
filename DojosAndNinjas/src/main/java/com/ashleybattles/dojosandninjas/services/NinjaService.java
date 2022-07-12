package com.ashleybattles.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashleybattles.dojosandninjas.models.Ninja;
import com.ashleybattles.dojosandninjas.repo.NinjaRepo;



@Service
public class NinjaService {
	@Autowired
	private NinjaRepo ninjaRepo;
	
	public Ninja save(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public List<Ninja> getAll(){
		return ninjaRepo.findAll();
	}
	
	public Ninja getOne(Long id) {
		Optional<Ninja> n = ninjaRepo.findById(id);
		
		if(n.isPresent()) {
			return n.get();
		}else {
			return null;
		}
	}
	
	public void delete(Long id) {
		ninjaRepo.deleteById(id);
	}

}
