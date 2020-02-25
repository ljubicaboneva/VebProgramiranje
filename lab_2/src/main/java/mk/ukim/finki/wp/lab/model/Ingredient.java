package mk.ukim.finki.wp.lab.model;

import javax.persistence.*;

@Entity
@Table(name="Ingredients")
public class Ingredient {

    @Id
    private String name;
    @Column
    private boolean spicy;
    @Column
    private float amount;
    @Column
    private boolean veggie;

    public Ingredient(String name, boolean spicy, float amount, boolean veggie) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
    }

    public Ingredient() {
        this.name = "";
        this.spicy = false;
        this.amount = 0;
        this.veggie = false;
    }


    public String getName(){
        return name;
    }

    public boolean getSpicy(){
        return spicy;
    }
    public float getAmount(){
        return amount;
    }
    public boolean getVeggie(){
        return veggie;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }
}
