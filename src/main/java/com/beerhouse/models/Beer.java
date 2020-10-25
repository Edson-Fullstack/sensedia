package com.beerhouse.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Beer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ingredients;

    @Column(name = "alcohol_content")
    private String alcoholContent;

    private BigDecimal price;

    private String category;

    public Beer(String name, String ingredients, String alcoholContent, BigDecimal price, String category) {
        this.setName(name);
        this.setIngredients(ingredients);
        this.setAlcoholContent(alcoholContent);
        this.setPrice(price);
        this.setCategory(category);
    }
}
