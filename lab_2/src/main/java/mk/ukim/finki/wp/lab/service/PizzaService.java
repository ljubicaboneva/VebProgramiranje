package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;

import java.util.List;

public interface PizzaService {

    Pizza create (Pizza pizza);

    Pizza edit (Pizza pizza, String id);

    void delete(String id);

    List<Pizza> getSpicyPizzas();

    List<Pizza> getAllPizzas();

    Pizza getPizza(String id);

    List<Pizza> getPizzasWithIngredient(Ingredient ingredient);

    List<Pizza> getAllPizzasLessThen(int total);

    List<Ingredient> getSameIngredients (Pizza pizza1,Pizza pizza2);

    Boolean checkPizza(Pizza pizza);




}
