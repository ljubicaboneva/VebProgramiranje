package mk.ukim.finki.wp.demo.repository;

import mk.ukim.finki.wp.demo.model.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository {


    private List<Food> foods = new ArrayList<>();

    public FoodRepository(){
        foods.add(new Food("Egg","ok",20));
        foods.add(new Food("Milk","white",50));
    }

    public List<Food> getAllFoods(){
        return foods;
    }

}
