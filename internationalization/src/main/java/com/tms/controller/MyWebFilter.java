package com.tms.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;


@WebFilter("/login")
public class MyWebFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) {
        this.context = fConfig.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> params = req.getParameterNames();

        String login = req.getParameter("login");

        if(Objects.isNull(login) || !login.equalsIgnoreCase("login")) throw new IllegalArgumentException("*************** WOOOHOOOOO EXCEPTION !!!!!*************");

        System.out.println("WE ARE INSIDE FILTER");

        req.setAttribute("FILTER", "ATTRIBUTE FROM FILTER");

        chain.doFilter(request, response);
    }

}