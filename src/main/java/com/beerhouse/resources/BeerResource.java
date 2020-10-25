package com.beerhouse.resources;

import com.beerhouse.models.Beer;
import com.beerhouse.repository.BeerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Arrays;
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
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<Beer> saveBeers(@Valid @RequestBody Beer[] beers){
        return beerRepository.saveAll(Arrays.asList(beers.clone()));
    }


    @ApiOperation(value = "Return a specific beer by id")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Beer> listBeer(@PathVariable(value = "id") String id) {
        Optional<Beer> beer = beerRepository.findById(Integer.valueOf(id));
        if(beer.isPresent()){
            return beer;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "entity not found"
            );
        }
    }
    @ApiOperation(value = "Update a beer and return the beer")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Beer updateBeers(@PathVariable(value = "id") String id,@Valid @RequestBody Beer beer){
        Optional<Beer> beerInternal=beerRepository.findById(Integer.valueOf(id));
        if(beer.getId()==null) {
            beer.setId(beerInternal.get().getId());
        }
        return beerRepository.save(beer);

    }

    @ApiOperation(value = "Update a beer and return the beer")
    @PatchMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Beer update2Beers(@PathVariable(value = "id") String id, @Valid @RequestBody Beer beer){
        Optional<Beer> beerInternal=beerRepository.findById(Integer.valueOf(id));
        Beer beerReturn = null;
        if(beerInternal.isPresent() && !beerInternal.equals(beer)) {
            beer.setId(beerInternal.get().getId());
            beerReturn = beerRepository.save(beer);
        }
        return beerReturn;
    }


    @ApiOperation(value = "Delete a beer by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable(value = "id") String id) {
        Optional<Beer> internalBeer=beerRepository.findById(Integer.valueOf(id));
        if(internalBeer.isPresent()){
            beerRepository.deleteById(Integer.valueOf(id));
        }else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }




}
