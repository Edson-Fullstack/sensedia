package com.beerhouse.repository;

import com.beerhouse.models.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBeerRepository extends JpaRepository<Beer, Long> {
}
