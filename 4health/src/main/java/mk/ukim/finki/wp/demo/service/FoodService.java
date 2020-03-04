package mk.ukim.finki.wp.demo.service;

import mk.ukim.finki.wp.demo.model.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface FoodService {

    List<Food> listFoods();

}
