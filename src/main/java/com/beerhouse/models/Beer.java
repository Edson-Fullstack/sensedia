package com.beerhouse.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Beer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    @Column(nullable = false)
    private String name;

    @JsonProperty("ingredients")
    @Column(nullable = false)
    private String ingredients;

    @Column(name = "alcohol_content")
    @JsonProperty("alcoholContent")
    private String alcoholContent;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("category")
    private String category;

}
