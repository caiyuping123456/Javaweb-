package com.chuyu.filter;


import com.chuyu.bean.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "AdminFilter",urlPatterns = "/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse requestp = (HttpServletResponse)resp;
        User u = (User) request.getSession().getAttribute("user");
        if(request.getRequestURI().equals("register.jsp")) return ;
        if(u==null || u.isFlag()==false) {
            requestp.sendRedirect("index.jsp");
        }else {
            // pass the request along the filter chain
            chain.doFilter(req, resp);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
