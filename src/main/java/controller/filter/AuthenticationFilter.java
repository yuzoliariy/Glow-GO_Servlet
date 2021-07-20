package controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;

    private final String[] loginRequiredUrls = {"/profile"};

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoginUser = (session != null && session.getAttribute("user") != null);

        String loginUri = httpRequest.getContextPath() + "/pages/login.jsp";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginUri);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (isLoginUser && (isLoginRequest || isLoginPage)) {
            httpResponse.sendRedirect("/index.jsp");
        } else if (!isLoginUser && isLoginRequired()) {
            httpResponse.sendRedirect("/login");
        } else {
            chain.doFilter(request, response);
        }
    }

    private boolean isLoginRequired() {
        String requestUrl = httpRequest.getRequestURL().toString();
        return Arrays.stream(loginRequiredUrls).anyMatch(requestUrl::contains);
    }
}
