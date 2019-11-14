package mk.ukim.finki.wp.lab.web.servlets;

import lombok.var;
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

@WebServlet(name = "PizzaOrder ",urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public PizzaOrder(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("myOrder");
        order.clientName = request.getParameter("clientName");
        order.clientAddress = request.getParameter("clientAddress");
        System.out.println("[WP-Log] {doPost PizzaOrder}");
        response.sendRedirect("/ConfirmationInfo.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebContext webContext = new WebContext(request, response, request.getServletContext());
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("myOrder");
        order.pizzaSize = (String) session.getAttribute("pizzaSize");
        webContext.setVariable("pizzaType", session.getAttribute("pizzaType"));
        webContext.setVariable("pizzaSize", session.getAttribute("pizzaSize"));
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("[WP-Log] {doGet PizzaOrder}");
        this.springTemplateEngine.process("deliveryInfo.html", webContext, response.getWriter());
    }
}
