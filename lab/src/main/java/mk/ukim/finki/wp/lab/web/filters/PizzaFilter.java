package mk.ukim.finki.wp.lab.web.filters;
import org.springframework.context.annotation.Profile;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter
public class PizzaFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletResponse httpResp = (HttpServletResponse) resp;

        HttpServletRequest httpRequest = (HttpServletRequest) req;

        String pizza = (String) httpRequest.getSession().getAttribute("pizzaType");
        String path = httpRequest.getServletPath();
        HttpSession session = httpRequest.getSession();
        if(!path.equals("") && (pizza == null || pizza.isEmpty())){
            httpResp.sendRedirect("/");

            session.setAttribute("message","Choose pizza!");

        }
        else {

            chain.doFilter(req, resp);


        }
    }
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
