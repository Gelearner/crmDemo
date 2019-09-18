package com.g.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "codeajaxServlet",value = "/checkajax")
public class codeajaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;cahrset=utf-8");
        String checkcheckcode = request.getParameter("checkcheckcode");
        HttpSession session = request.getSession();
        String servercode = (String) session.getAttribute("servercode");
        if (checkcheckcode.equalsIgnoreCase(servercode)){
            response.getWriter().write("codeyes");
        }else {
            response.getWriter().write("codeno");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
