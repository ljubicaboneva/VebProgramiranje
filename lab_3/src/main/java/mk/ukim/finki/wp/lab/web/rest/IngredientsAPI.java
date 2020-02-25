package mk.ukim.finki.wp.lab.web.rest;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.service.IngredientService;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/ingredients")
public class IngredientsAPI {

    @Autowired
    private  IngredientService ingredientService;
    @Autowired
    private  PizzaService pizzaService;


    @PostMapping
    public Ingredient createIngredient(@RequestParam("name") String ingName,
                                       @RequestParam("spicy") boolean ingSpicy,
                                       @RequestParam("amount") float ingAmount,
                                       @RequestParam("veggie") boolean ingVeggie)
    {
        Ingredient ingredient = ingredientService.create(new Ingredient(ingName,ingSpicy,ingAmount,ingVeggie));
        return ingredient;
    }

    @PatchMapping("/{id}")
    public Ingredient editIngredient(@RequestParam("spicy") boolean ingSpicy,
                                     @RequestParam("amount") float ingAmount,
                                     @RequestParam("veggie") boolean ingVeggie,
                                     @PathVariable String id){
        return ingredientService.edit(new Ingredient(id,ingSpicy,ingAmount,ingVeggie),id);
    }
    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable String id){
        ingredientService.delete(id);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient (@PathVariable String id){
        return ingredientService.getIngredientById(id);
    }

    @GetMapping()
    public Page<Ingredient> getAllIngredients(@RequestHeader(name="page", defaultValue = "0", required = false) int page,
                                              @RequestHeader(name="page-size", defaultValue = "10", required = false) int size){

        return ingredientService.getAllIngredientsByPage(page, size);
    }

    @GetMapping(params = "spicy")
    public List<Ingredient> getSpicy(@RequestParam("spicy") boolean spicy){
        return ingredientService.getAllSpicyIngredients (spicy);
    }

    @GetMapping("/{id}/pizzas")
    public List<Pizza> getAllPizzasByIngredient(@PathVariable String id){
    return pizzaService.getPizzasWithIngredient(ingredientService.getIngredientById(id));
    }

}
