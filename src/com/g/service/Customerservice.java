package com.g.service;

import com.g.dao.Customerdao;
import com.g.domain.Customer;
import com.g.domain.PageBean;

import java.util.List;

public class Customerservice {
    public PageBean findall(PageBean pageBean) throws Exception {
        Customerdao customerdao = new Customerdao();
        PageBean pageBean1=customerdao.findall(pageBean);
        return pageBean1;
    }

    public boolean addcustomer(Customer customer) throws Exception {
       boolean b= new Customerdao().addcustomer(customer);
        return b;
    }

    public boolean delCustomer(String cid) throws Exception {
        boolean b=new Customerdao().delCustomer(cid);
        return  b;
    }

    public Customer findupdate(String cid) throws Exception {
        return new Customerdao().findupdate(cid);
    }

    public boolean update(Customer customer) throws Exception {
        return new Customerdao().update(customer);

    }

    public boolean delcheck(String[] cids) throws Exception{
        return new Customerdao().delcheck(cids);
    }

    public List<Customer> query(String cname) throws Exception {
        return new Customerdao().query(cname);
    }
}
