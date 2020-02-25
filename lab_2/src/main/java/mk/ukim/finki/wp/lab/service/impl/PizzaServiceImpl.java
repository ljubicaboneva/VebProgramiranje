package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.model.exeptions.InvalidIngredientException;
import mk.ukim.finki.wp.lab.model.exeptions.InvalidPizzaException;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;



    @Override
    public Pizza create(Pizza pizza) {
        checkPizza(pizza);
        return this.pizzaRepository.save(pizza);
    }

    @Override
    public Pizza edit(Pizza pizza, String id) {
        Pizza pica = this.pizzaRepository.findById(id).orElseThrow(InvalidPizzaException::new);
        pizza.setName(pica.getName());
        pizza.setDescription(pica.getDescription());
        pizza.setVeggie(pica.getVeggie());
        pizza.setIngredients(pica.getIngredients());
        checkPizza(pizza);
        return this.pizzaRepository.save(pizza);
    }

    @Override
    public void delete(String id) {
        Pizza p = this.pizzaRepository.findById(id).orElseThrow(InvalidPizzaException::new);
        this.pizzaRepository.delete(p);
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizza(String id) {
        return this.pizzaRepository.findById(id).orElseThrow(InvalidPizzaException::new);
    }

    @Override
    public List<Pizza> getPizzasWithIngredient(Ingredient ingredient) {

        return this.pizzaRepository.findAllByIngredients(ingredient);
    }

    @Override
    public List<Pizza> getAllPizzasLessThen(int total) {
        return pizzaRepository.findAllByTotalLessThan(total);
    }

    @Override
    public List<Pizza> getSpicyPizzas() {
        return pizzaRepository.getSpicyPizzas();
    }

    @Override
    public List<Ingredient> getSameIngredients(Pizza pizza1, Pizza pizza2) {
        List<Ingredient> ingredientList = new ArrayList<>();;
        for(int i = 0;i<pizza1.getIngredients().size();i++) {
            Ingredient ingredient = pizza1.getIngredients().get(i);
            if(pizza2.getIngredients().contains(ingredient)) {
                ingredientList.add(ingredient);
            }
        }

        return ingredientList;
    }


    @Override
    public Boolean checkPizza(Pizza pizza) {
        if(pizza.getVeggie()){
            for(int i=0;i<pizza.getIngredients().size();i++){
                Ingredient ingredient = pizza.getIngredients().get(i);
                if(!ingredient.getVeggie()){
                     throw new InvalidPizzaException();
                }
            }
        }
        return true;
    }


}
