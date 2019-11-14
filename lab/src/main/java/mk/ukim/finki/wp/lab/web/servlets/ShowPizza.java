package mk.ukim.finki.wp.lab.web.servlets;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.service.PizzaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;


@WebServlet(name = "ShowPizza", urlPatterns = "")
public class ShowPizza extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final PizzaService pizzaService;

    public ShowPizza(SpringTemplateEngine springTemplateEngine, PizzaService pizzaService) {
        this.springTemplateEngine = springTemplateEngine;
        this.pizzaService = pizzaService;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        List<Pizza> pizzas = pizzaService.listPizzas();
        webContext.setVariable("pizzas", pizzas);
        webContext.setVariable("message", session.getAttribute("message"));
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("[WP-Log] {doGet ShowPizzas}");
        this.springTemplateEngine.process("listPizzas.html", webContext, response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String pizzaType = request.getParameter("pizza");
        String newPizza = request.getParameter("newPizzaName");
        String newPizzaDesc = request.getParameter("newPizzaDesc");
        if(!newPizza.equals("") && !newPizzaDesc.equals("")){
            pizzaService.listPizzas().add(new Pizza(newPizza,newPizzaDesc));
        }
        session.setAttribute("pizzaType",pizzaType);
        System.out.println("[WP-Log] {doPost ShowPizzas}");
        response.sendRedirect("/selectPizza.do");


    }
}
