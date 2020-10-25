package com.beerhouse.resources;

import com.beerhouse.models.Beer;
import com.beerhouse.repository.BeerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

        /*public ResponseEntity saveBeers(@Valid @RequestBody Beer[] beers){
        List<Beer> savedBeers=beerRepository.saveAll(Arrays.asList(beers.clone()));
        ResponseEntity response = new ResponseEntity(HttpStatus.CREATED);
        return response;
    }*/

    @ApiOperation(value = "Return a specific beer by id")
    @GetMapping("/{id}")
    public Optional<Beer> listBeer(@PathVariable(value = "id") Integer id) {
        return beerRepository.findById(id);
    }
    @ApiOperation(value = "Update a beer and return the beer")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Beer updateBeers(@PathVariable(value = "id") Integer id,@Valid @RequestBody Beer beer){
        Optional<Beer> beerInternal=beerRepository.findById(id);
        Beer beerReturn = null;
        if(!beerInternal.equals(beer)) {
            beerReturn = beerRepository.save(beer);
        }
        return beerReturn;
    }


    @ApiOperation(value = "Delete a beer by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable(value = "id") Integer id) {
        Optional<Beer> internalBeer=beerRepository.findById(id);
        if(internalBeer.isPresent()){
            beerRepository.deleteById(id);
        }
    }

}
