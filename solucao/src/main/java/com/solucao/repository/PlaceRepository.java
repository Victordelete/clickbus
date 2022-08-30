package com.solucao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solucao.domain.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer>{

}
