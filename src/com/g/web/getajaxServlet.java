package com.g.web;

import com.g.service.Userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getajaxServlet",value = "/getajax")
public class getajaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;cahrset=utf-8");
            String username = request.getParameter("username");
            boolean b=new Userservice().findusername(username);
            if (b){
                response.getWriter().write("yes");
            }else {
                response.getWriter().write("no");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
