package com.beerhouse.resources;

import com.beerhouse.models.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BeerResourceTest {

    @Test
    void listBeers() {
        BeerResource beerResource = new BeerResource();


    }

    @Test
    void saveBeer() {
        BeerResource beerResource = new BeerResource();
        Beer beer= new Beer(
                "teste",
                "teste",
                "teste",
                new BigDecimal(10),
                "teste");
        Beer savedBeer=beerResource.saveBeer(beer);
        Assert.notNull(savedBeer);
    }

    @Test
    void listBeer() {
    }
}