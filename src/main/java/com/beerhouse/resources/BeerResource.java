package com.beerhouse.resources;

import com.beerhouse.models.Beer;
import com.beerhouse.repository.BeerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/beers")
@Api(value="API REST BEERHOUSE")
@CrossOrigin(origins = "*")
public class BeerResource {
    @Autowired
    BeerRepository beerRepository;

    @ApiOperation(value = "Return a beer list")
    @GetMapping()
    public List<Beer> listBeers() {
        return beerRepository.findAll();
    }
    @ApiOperation(value = "Create a beer and return the beer")
    @PostMapping()
    public Beer saveBeer(@RequestBody Beer beer){
        return beerRepository.save(beer);
    }

    @ApiOperation(value = "Return a specific beer by id")
    @GetMapping("/{id}")
    public Optional<Beer> listBeer(@PathVariable(value = "id") Integer id) {
        return beerRepository.findById(id);
    }

}
