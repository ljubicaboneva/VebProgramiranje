package mk.ukim.finki.wp.lab.repository;
import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface PizzaRepository extends JpaRepository<Pizza, String> {

    @Query("SELECT p FROM Pizza p JOIN p.ingredients i WHERE i.spicy = true")
    List<Pizza> getSpicyPizzas();

    List<Pizza>  findAllByIngredients(Ingredient ingredient);

    List<Pizza> findAllByTotalLessThan(int count);

}