package com.beerhouse.repository;

import com.beerhouse.models.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeerRepository extends JpaRepository<Beer, Integer> {

}
