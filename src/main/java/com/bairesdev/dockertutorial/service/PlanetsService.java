package com.bairesdev.dockertutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bairesdev.dockertutorial.model.entity.Planets;
import com.bairesdev.dockertutorial.model.repository.PlanetsRepository;

@Service
public class PlanetsService {

    private PlanetsRepository planetsRepository;

    @Autowired
    private PlanetsService(PlanetsRepository planetsRepository) {
        super();
        this.planetsRepository = planetsRepository;
    }

    public List<Planets> getAllPlanets() {
        return planetsRepository.findAll();
    }

    public Planets getPlanetByName(String name) {
        return planetsRepository.findByNameIgnoreCase(name);
    }

}
