package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Ingredient;

import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.model.exeptions.IngredientNameException;
import mk.ukim.finki.wp.lab.model.exeptions.InvalidIngredientException;

import mk.ukim.finki.wp.lab.repository.IngredientsRepository;

import mk.ukim.finki.wp.lab.service.IngredientService;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private  IngredientsRepository ingredientsRepository;
    @Autowired
    private PizzaService pizzaService;




    @Override
    public Ingredient create(Ingredient ingredient) {
        if(ingredient.getSpicy()){
            limitSpicy();
        }
        checkIngredient(ingredient.getName());
        return this.ingredientsRepository.save(ingredient);


    }

    @Override
    public Ingredient edit(Ingredient ingredient, String id) {
        Ingredient ing = this.ingredientsRepository.findById(id).orElseThrow(InvalidIngredientException::new);
        ing.setName(ingredient.getName());
        ing.setSpicy(ingredient.getSpicy());
        ing.setAmount(ingredient.getAmount());
        ing.setVeggie(ingredient.getVeggie());
        return this.ingredientsRepository.save(ing);

    }


    @Override
    public void delete(String id) {
        Ingredient i = getIngredientById(id);
        List<Pizza> pizzas = pizzaService.getPizzasWithIngredient(i);
        pizzas.forEach(pizza -> {
            pizza.setIngredients(pizza.getIngredients().stream().filter(ingredient -> !ingredient.equals(id)).collect(Collectors.toList()));

        });
        this.ingredientsRepository.delete(i);
    }

    @Override
    public List<Ingredient> getAllIngredientsByAlphabet() {
        return ingredientsRepository.findByOrderByNameAsc();
    }

    @Override
    public Page<Ingredient> getAllIngredientsByPage(int page, int size){
        Page<Ingredient> result = this.ingredientsRepository.findAll(PageRequest.of(page, size));
        return result;
    }


    @Override
    public Ingredient getIngredientById(String id) {
        Ingredient ingredient = this.ingredientsRepository.findById(id).orElseThrow(InvalidIngredientException::new);
        return ingredient;
    }

    @Override
    public List<Ingredient> getAllSpicyIngredients(boolean spicy) {
       return this.ingredientsRepository.findAllBySpicy(spicy);
    }

    public void limitSpicy() {
        List<Ingredient> spicyIngredients = ingredientsRepository.findAllBySpicy(true);
        if(spicyIngredients.size() == 3)
            throw new IngredientNameException("Limit of 3 spicy ingredients reached");

        }


    public void checkIngredient(String id) {
        if(ingredientsRepository.existsById(id))
                throw new IngredientNameException("Same ingredient");
            }


}
