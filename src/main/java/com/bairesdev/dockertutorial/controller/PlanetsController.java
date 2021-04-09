package com.bairesdev.dockertutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bairesdev.dockertutorial.model.entity.Planets;
import com.bairesdev.dockertutorial.service.PlanetsService;


@RestController
public class PlanetsController {
	
	private PlanetsService planetsService;
	
	@Autowired
	private PlanetsController(PlanetsService planetsService) {
		super();
		this.planetsService = planetsService;
	}

	@GetMapping(path = "/allPlanets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Planets>> getAllPlanets() {
		List<Planets> planetsList = planetsService.getAllPlanets();
        return new ResponseEntity<>(planetsList, HttpStatus.OK);
    }
	
	@GetMapping(path = "/planetByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planets> getPlanetByName(@PathVariable(required = true) String name) {
		Planets planet = planetsService.getPlanetByName(name);
        return new ResponseEntity<>(planet, HttpStatus.OK);
    }
	
}
