package com.g.web;

import com.g.domain.Customer;
import com.g.service.Customerservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "querycustomerServlet",value = "/querycustomer")
public class querycustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String cname = request.getParameter("cname");
            List<Customer> list =new Customerservice().query(cname);
            if (list != null&&list.size()>0) {
                request.setAttribute("customerlist",list);
                request.getRequestDispatcher("querycustomer.jsp").forward(request,response);
            }else {
                response.getWriter().write("查询失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
