package mk.ukim.finki.wp.lab.web.rest;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.service.IngredientService;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzasAPI {

    @Autowired
    private  IngredientService ingredientService;
    @Autowired
    private  PizzaService pizzaService;


    @PostMapping
    public Pizza createPizza(@RequestParam("name") String PizzaName,
                             @RequestParam("description") String DescPizza,
                             @RequestParam("ingredients") String[] ingredients
                             )
    {
        List<Ingredient> ingredientList = new ArrayList<>();
        for(int i=0; i<ingredients.length; i++){
            Ingredient ingredient = ingredientService.getIngredientById(ingredients[i]);
            ingredientList.add(ingredient);
        }
        Pizza pizza = new Pizza(PizzaName, DescPizza, ingredientList);
        return pizzaService.create(pizza);
    }

    @PutMapping("/{id}")
    public Pizza editPizza(@RequestParam("name") String PizzaName,
                           @RequestParam("description") String DescPizza,
                           @RequestParam("ingredients") List<Ingredient> PizzaIngred,
                           @RequestParam("veggie") boolean PizzaVeggie,
                            @PathVariable String id){
        return pizzaService.edit(new Pizza(PizzaName,DescPizza,PizzaIngred,PizzaVeggie),id);
    }
    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable String id){
        pizzaService.delete(id);
    }
    @GetMapping
    public List<Pizza> getPizzas(){
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public Pizza get (@PathVariable String id){
        return pizzaService.getPizza(id);
    }

    @GetMapping(params = "totalIngredients")
    public List<Pizza> getPizzasLessThen(@RequestParam("totalIngredients") int count){
    return pizzaService.getAllPizzasLessThen(count);
    }

    @GetMapping(value = "/compare")
    public List<Ingredient> getSameIngredients(@RequestParam("pizza1") Pizza p1,
                                               @RequestParam("pizza2") Pizza p2){
        return pizzaService.getSameIngredients(p1,p2);
    }

    @GetMapping("/spicy")
    public List<Pizza> getSpicyPizzas(){

        return pizzaService.getSpicyPizzas();
    }


}
