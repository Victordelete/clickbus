package com.solucao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.solucao.domain.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer>{
	
	public Optional<Place> findById(Integer id);
	
	public Optional<List<Place>> findByName(String name);
	
	public Optional<List<Place>> findByCity(String city);
	
	public Optional<List<Place>> findByCountry(String country);
	
	public Optional<List<Place>> findByState(String state);
	
}
