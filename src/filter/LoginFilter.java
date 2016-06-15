package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/pages/intern/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("Login Filter");

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        HttpSession session = httpRequest.getSession(true);

        if(session.getAttribute("loggedin") != null && session.getAttribute("loggedin").equals("true")) {
            chain.doFilter(request, response);
        }
        else {
            String URL = httpResponse.encodeRedirectURL("/pages/index.jsf");
            httpResponse.sendRedirect(URL);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
