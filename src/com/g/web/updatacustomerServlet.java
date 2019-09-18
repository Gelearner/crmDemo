package com.g.web;

import com.g.domain.Customer;
import com.g.service.Customerservice;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "updatacustomerServlet",value = "/updatacustomer")
public class updatacustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Customer customer = new Customer();
            Map<String, String[]> map = request.getParameterMap();
            new BeanUtils().populate(customer,map);
            boolean b =new Customerservice().update(customer);
            if (b){
                request.getRequestDispatcher("/findall").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
