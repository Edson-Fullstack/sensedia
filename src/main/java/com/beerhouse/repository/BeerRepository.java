package com.beerhouse.repository;

import com.beerhouse.models.Beer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@EntityScan(basePackages = {"com.mypackage.entity"})
public interface BeerRepository extends JpaRepository<Beer, Integer> {

}
