package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;

import java.util.List;

public interface PizzaService {


    List<Pizza> listPizzas();

}
