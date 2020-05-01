package com.tms.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String locale = request.getParameter("lang");
        locale = Objects.nonNull(locale) ? locale : "en";
        switch (locale) {
            case ("es"):
                Locale.setDefault(new Locale("es", "ES"));
                break;
            case ("it"):
                Locale.setDefault(Locale.ITALIAN);
                break;
            default:
                Locale.setDefault(Locale.ENGLISH);
                break;
        }
        ResourceBundle mybundle = ResourceBundle.getBundle("message");

        request.setAttribute("loginMsg", mybundle.getString("msg.login.text"));
        request.setAttribute("language", Locale.getDefault());
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResourceBundle mybundle = ResourceBundle.getBundle("message");

        PrintWriter out = response.getWriter();

        out.write("<html><h2> Current Locale: " + Locale.getDefault() +" </h2></html>");
        out.write("<p> " + mybundle.getString("msg.login.incorrect") + " </p></html>");
    }
}
