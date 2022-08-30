package com.solucao.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "placeDB")
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	//Im not 100 sure about the best way to put this parameter.
	//@Column
	//private String slug;
	
	//Im going to use this criation direct, but later create bd to 
	//country and states
	@Column(length = 50, nullable = false)
	private String country;
	
	@Column(length = 50, nullable = false)
	private String city;
	
	@Column(length = 50, nullable = false)
	private String state;
	
	@Column(length = 200)
	private String imagePath;
	
	@Column
	private LocalDate createdAt;
	@Column
	private LocalDate updatedAt; 
}
