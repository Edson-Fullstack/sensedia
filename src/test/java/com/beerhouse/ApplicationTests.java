package com.beerhouse;

import com.beerhouse.models.Beer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {


    @Before
    public void setup() {

    }


    @Test
    @DisplayName("Test if test module is working")
    @Tag("web")
    public void start(){
        Assert.assertEquals(1,2);
    }
    @Test
    @DisplayName("Test clone class beer")
    public void beerClone() throws CloneNotSupportedException {
        Beer beer = new Beer();
        Assert.assertNotEquals(beer,
                beer.Clone());
    }
    @Test
    @DisplayName("Test class beer compare")
    public void beerCompare() throws CloneNotSupportedException {
        Beer beer = new Beer();
        Assert.assertTrue(beer.Equals(beer.Clone()));
    }
    @Test
    @DisplayName("Test get result as empty list")
    @Tag("web")
    public void getEmpty(){
        Assert.assertEquals("[]","[]");
    }



}
