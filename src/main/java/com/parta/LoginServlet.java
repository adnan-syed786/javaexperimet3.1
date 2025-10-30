package com.parta;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("Adnan".equals(user) && "Adnan786@".equals(pass)) {
            out.println("<h2>Welcome, " + user + "!</h2>");
        } else {
            out.println("<h3 style='color:red;'>Invalid Username or Password!</h3>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Optional: handle GET requests
        doPost(request, response);
    }
}
