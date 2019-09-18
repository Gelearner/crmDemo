package com.g.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "exithomeServlet",value = "/exit")
public class exithomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进来了");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ucookie")){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("pcookie")){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
