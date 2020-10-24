package com.beerhouse.resources;

import com.beerhouse.models.Beer;
import com.beerhouse.repository.IBeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/beers")
public class BeerResource {
    @Autowired
    IBeerRepository beerRepository;

    @GetMapping("/")
    public List<Beer> listBeers() {
        return beerRepository.findAll();
    }

//    @GetMapping("/{id}")
//    public Beer listBeer(@PathVariable(value = "id") long id) {
//        return (Beer)beerRepository.findOne(id);
//    }

}
