package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {

    Ingredient create(Ingredient ingredient);

    Ingredient edit(Ingredient ingredient, String id);

    void delete(String id);

    List<Ingredient> getAllIngredientsByAlphabet();

    Ingredient getIngredientById(String id);

    Page<Ingredient> getAllIngredientsByPage(int page, int size);

    List<Ingredient> getAllSpicyIngredients(boolean spicy);








}
