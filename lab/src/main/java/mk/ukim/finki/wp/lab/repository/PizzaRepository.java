package mk.ukim.finki.wp.lab.repository;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class PizzaRepository {
    private List<Pizza> pizzas=new ArrayList<>();

    public PizzaRepository(){

        pizzas.add(new Pizza("Margherita", "tomato sauce, mozzarella"));
        pizzas.add(new Pizza("Carbonara", "fresh cream, mozzarella, bacon"));
        pizzas.add(new Pizza("Vegetariana ", "tomato sauce, mushrooms"));
        pizzas.add(new Pizza("Calzone", "Pizza dough, ricotta, pepperoni, pizza sauce, olive oil"));
        pizzas.add(new Pizza("Cheddar", "cheddar, tomato sauce"));
        pizzas.add(new Pizza("Capricciosa ", "tomato sauce, cheese, ham"));
        pizzas.add(new Pizza("Burger Classic", "barbecue sauce, beef, mozzarella, onions"));
        pizzas.add(new Pizza("Burger Barbecue", "ham, chicken meat, onions"));
        pizzas.add(new Pizza("Pepperoni", "tomato sauce, mozzarella, sausage"));
        pizzas.add(new Pizza("Quattro Formaggi", "Taleggio, Mascarpone, Gorgonzola, Parmesan"));

    }

    public List<Pizza> getAllPizzas() {
        return pizzas;
    }

}