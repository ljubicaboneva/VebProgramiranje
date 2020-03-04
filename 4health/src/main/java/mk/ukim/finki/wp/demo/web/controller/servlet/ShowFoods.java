package mk.ukim.finki.wp.demo.web.controller.servlet;

import mk.ukim.finki.wp.demo.model.Food;
import mk.ukim.finki.wp.demo.service.FoodService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowFoods", urlPatterns = "")
public class ShowFoods extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final FoodService foodService;

    public ShowFoods(SpringTemplateEngine springTemplateEngine, FoodService foodService) {
        this.springTemplateEngine = springTemplateEngine;
        this.foodService = foodService;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        WebContext webContext = new WebContext(request, response, request.getServletContext());
        List<Food> foods = foodService.listFoods();
        webContext.setVariable("foods", foods);
        response.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listFoods.html", webContext, response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





    }

}
