package mk.ukim.finki.wp.demo.service.impl;

import mk.ukim.finki.wp.demo.model.Food;
import mk.ukim.finki.wp.demo.repository.FoodRepository;
import mk.ukim.finki.wp.demo.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> listFoods(){
        return this.foodRepository.getAllFoods();
    }
}
