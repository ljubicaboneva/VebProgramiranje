package mk.ukim.finki.wp.lab.web.servlets;

import mk.ukim.finki.wp.lab.model.Order;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SelectPizza" , urlPatterns = "/selectPizza.do")
public class SelectPizza extends HttpServlet {
    public Order order = new Order();

    private final SpringTemplateEngine springTemplateEngine;

    public SelectPizza(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String pizzaSize = request.getParameter("pizza_size");
        session.setAttribute("pizzaSize",pizzaSize);
        response.sendRedirect("/PizzaOrder.do");


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        order.pizzaType = (String) session.getAttribute("pizzaType");
        session.setAttribute("myOrder",order);
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        webContext.setVariable("pizzaType", session.getAttribute("pizzaType"));
        System.out.println("[WP-Log] {SelectPizza}");
        this.springTemplateEngine.process("selectPizzaSize.html", webContext, response.getWriter());

    }
}
