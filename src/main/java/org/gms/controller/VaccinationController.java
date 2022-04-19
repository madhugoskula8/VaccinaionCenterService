package org.gms.controller;

import org.gms.entity.Citizen;
import org.gms.entity.VaccinationCenter;
import org.gms.entity.requiredResponce.RequiredResponce;
import org.gms.repository.VaccinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import antlr.collections.List;

@RestController
@RequestMapping(path="/vaccination")
public class VaccinationController {

	@Autowired
	private VaccinationRepo repo;
	
	@Autowired
	private RestTemplate temp;
	
	@GetMapping(path="/id/{id}")
	public ResponseEntity< RequiredResponce> show(@PathVariable Integer id) {
		RequiredResponce resp=new RequiredResponce();
		
	//	VaccinationCenter center=repo.findById(id).get();
		resp.setCenter(repo.findById(id).get());
		
		java.util.List<Citizen> listOfCitizen=(java.util.List<Citizen>)
				temp.getForObject("http://CITIZEN-CENTER-SERVICE/citizen/"+id, List.class);
		resp.setCitizen(listOfCitizen);
		
		
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	@PostMapping(path="/add")
	public void add(@RequestBody VaccinationCenter center) {
		repo.save(center);
	}
	
}
