package com.bairesdev.dockertutorial.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bairesdev.dockertutorial.model.entity.Planets;

public interface PlanetsRepository extends JpaRepository<Planets, Long> {
	
	Planets findByNameIgnoreCase(String name);
	
}
