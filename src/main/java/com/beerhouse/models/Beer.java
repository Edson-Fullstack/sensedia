package com.beerhouse.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Beer implements com.beerhouse.models.interfaces.IBeer , Cloneable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    @NotBlank(message = "Name is mandatory")
    private String name;

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
    public Beer Clone() throws CloneNotSupportedException {
        return (Beer) this.clone();
    }

    public boolean Equals(Beer beer) {
        if(this.getId()==beer.getId() &&
            this.getName()==beer.getName() &&
            this.getIngredients()==beer.getIngredients() &&
            this.getAlcoholContent()==beer.getAlcoholContent() &&
            this.getPrice()==beer.getPrice() &&
            this.getCategory()==beer.getCategory()) {
                return true;
        }else{
                return false;
        }
    }
}
