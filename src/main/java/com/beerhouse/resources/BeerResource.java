package com.beerhouse.resources;

import com.beerhouse.models.Beer;
import com.beerhouse.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/beers")
public class BeerResource {
    @Autowired
    BeerRepository beerRepository;

    @GetMapping("/{id}")
    public Optional<Beer> listBeer(@PathVariable(value = "id") Integer id) {
        return beerRepository.findById(id);
    }
    @GetMapping()
    public List<Beer> listBeers() {
        return beerRepository.findAll();
    }
    
}
