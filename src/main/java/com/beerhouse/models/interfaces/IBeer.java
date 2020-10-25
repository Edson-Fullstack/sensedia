package com.beerhouse.models.interfaces;

import java.io.Serializable;

public interface IBeer extends Serializable {
    void setId(Integer id);

    void setName(String name);

    void setIngredients(String ingredients);

    void setAlcoholContent(String alcoholContent);

    void setPrice(java.math.BigDecimal price);

    void setCategory(String category);

    Integer getId();

    String getName();

    String getIngredients();

    String getAlcoholContent();

    java.math.BigDecimal getPrice();

    String getCategory();
}
