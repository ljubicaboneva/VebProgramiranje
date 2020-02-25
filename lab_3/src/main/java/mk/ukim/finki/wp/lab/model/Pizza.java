package mk.ukim.finki.wp.lab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;

@Entity
@Table(name="Pizzas")
public class Pizza {

    @Id
    public String name;
    @Column
    public String description;
    @ManyToMany()
    private List<Ingredient> ingredients;
    @Column
    private boolean veggie;
    @Column
    private int total;

    public Pizza(String name, String description, List<Ingredient> ingredients, boolean veggie){
        this.name= name;
        this.description = description;
        this.ingredients = ingredients;
        this.veggie = veggie;
        this.total = ingredients.size();
    }
    public Pizza(String name, String description, List<Ingredient> ingredients){
        this.name= name;
        this.description = description;
        this.ingredients = ingredients;

    }


    public Pizza(){
        this.name = "";
        this.description = "";
        this.ingredients = new ArrayList<>();
        this.veggie = false;
        this.total = 0;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public boolean getVeggie(){
        return veggie;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }
    public List<Ingredient> getIngredients(){
        return this.ingredients;
    }
    public void setIngredients(List<Ingredient> ingredientList){
        this.ingredients=ingredientList;
    }

}
