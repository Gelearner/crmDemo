package com.g.web;

import com.g.Utils.Utils;
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

@WebServlet(name = "addCustomerServlet",value = "/addCustomer")
public class addCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            Customer customer = new Customer();
            customer.setCid(Utils.getuuid());
            Map<String, String[]> map = request.getParameterMap();
            new BeanUtils().populate(customer,map);
            boolean b =new Customerservice().addcustomer(customer);
            if (b){
               request.getRequestDispatcher("/findall").forward(request,response);
            }else {
                request.setAttribute("addmsg","添加失败");
                request.getRequestDispatcher("addcustomer.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
