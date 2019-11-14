package mk.ukim.finki.wp.lab.web.servlets;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ConfirmationInfo", urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[WP-Log] {doPost ConfirmationInfo}");
        response.sendRedirect("/logout");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebContext webContext = new WebContext(request, response, request.getServletContext());
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("myOrder");

        orderService.placeOrder(order.pizzaType,order.clientName,order.clientAddress);
        webContext.setVariable("pizzaSize", order.pizzaSize);
        webContext.setVariable("pizzaType", order.pizzaType);
        webContext.setVariable("clientName", order.clientName);
        webContext.setVariable("clientAddress", order.clientAddress);
        webContext.setVariable("ipaddress", request.getRemoteHost());
        webContext.setVariable("browser", request.getHeader("User-Agent"));
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("[WP-Log] {doGet ConfirmationInfo}");
        this.springTemplateEngine.process("confirmationInfo.html", webContext, response.getWriter());
    }
}
