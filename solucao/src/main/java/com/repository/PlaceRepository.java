package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer>{

}
