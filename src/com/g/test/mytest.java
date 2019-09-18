package com.g.test;

import com.g.Utils.Utils;
import com.g.dao.Customerdao;
import com.g.domain.Customer;
import com.g.domain.PageBean;


public class mytest {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        PageBean pageBean = new PageBean();
        PageBean findall = new Customerdao().findall(pageBean);
        System.out.println(findall);
    }
}
