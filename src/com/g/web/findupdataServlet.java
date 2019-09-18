package com.g.web;

import com.g.domain.Customer;
import com.g.service.Customerservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "findupdataServlet",value = "/findupdata")
public class findupdataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String cid = request.getParameter("cid");
            if (cid != null) {
                Customer customer=new Customerservice().findupdate(cid);
                if (customer!=null){
                    request.setAttribute("customer",customer);
                    request.getRequestDispatcher("updatacustomer.jsp").forward(request,response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
