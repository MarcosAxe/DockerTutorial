package com.bairesdev.dockertutorial.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="planets")
@Data
public class Planets {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "planets_seq")
    @SequenceGenerator(name = "planets_seq", sequenceName = "planets_seq", allocationSize = 1)
	@JsonIgnore
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "diameter", nullable = false)
    private Double diameter;
    
    @Column(name = "gravity", nullable = false)
    private Double gravity;
    
    @Column(name = "rotation_period", nullable = false)
    private Double rotationPeriod;
    
    @Column(name = "lenght_of_day", nullable = false)
    private Double lenghtOfDay;
    
    @Column(name = "distance_from_sun", nullable = false)
    private Double distanceFromSun;
    
    @Column(name = "orbital_period", nullable = false)
    private Double orbitalPeriod;
    
    @Column(name = "mean_temperature", nullable = false)
    private Integer meanTemperature;
    
    @Column(name = "number_of_moons", nullable = false)
    private Integer numberOfMoons;
    
    @Column(name = "ring_system", nullable = false)
    private Boolean ringSystem;
    
   
}
