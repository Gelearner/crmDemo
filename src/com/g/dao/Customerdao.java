package com.g.dao;

import com.g.Utils.Utils;
import com.g.domain.Customer;
import com.g.domain.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class Customerdao {
    public PageBean findall(PageBean pageBean) throws Exception {
        DataSource datasource = Utils.getdatasource();
        QueryRunner queryRunner = new QueryRunner(datasource);
        int currentPage = pageBean.getCurrentPage();
        int pageCount = pageBean.getPageCount();
        int index = (currentPage - 1) * pageCount;
        List<Customer> list = queryRunner.query("select * from customer limit ?,?", new BeanListHandler<Customer>(Customer.class), index, pageCount);
        QueryRunner queryRunner1 = new QueryRunner(datasource);
        Long query = (Long) queryRunner1.query("select count(*) from customer", new ScalarHandler());
        pageBean.setTotalCount(query.intValue());
        pageBean.setPageData(list);
        return pageBean;
    }

    public boolean addcustomer(Customer customer) throws Exception {
        DataSource datasource = Utils.getdatasource();
        QueryRunner queryRunner = new QueryRunner(datasource);
        int i = queryRunner.update("insert into customer values(?,?,?,?,?,?,?)", customer.getCid(), customer.getCname(), customer.getAge(), customer.getGender(), customer.getEmail(), customer.getTelephone(), customer.getDescription());
        return i > 0;
    }

    public boolean delCustomer(String cid) throws Exception {
        DataSource datasource = Utils.getdatasource();
        QueryRunner queryRunner = new QueryRunner(datasource);
        int i = queryRunner.update("delete from customer where cid=?", cid);
        return i > 0;
    }

    public Customer findupdate(String cid) throws Exception {
        DataSource datasource = Utils.getdatasource();
        QueryRunner queryRunner = new QueryRunner(datasource);
        Customer customer = queryRunner.query("select * from customer where cid=?", new BeanHandler<Customer>(Customer.class), cid);
        return customer;
    }

    public boolean update(Customer customer) throws Exception {
        DataSource datasource = Utils.getdatasource();
        QueryRunner queryRunner = new QueryRunner(datasource);
        String sql = "update customer set cname=?,age=?,gender=?,email=?,telephone=?,description=? where cid=?";
        int i = queryRunner.update(sql, customer.getCname(), customer.getAge(), customer.getGender(), customer.getEmail(), customer.getTelephone(), customer.getDescription(), customer.getCid());
        return i > 0;
    }

    public boolean delcheck(String[] cids) throws Exception {
        DataSource datasource = Utils.getdatasource();
        Connection conn = datasource.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("delete from customer where cid=?");
        for (String cid : cids) {
            preparedStatement.setString(1, cid);
            preparedStatement.addBatch();
        }
        int[] ints = preparedStatement.executeBatch();
        preparedStatement.clearBatch();
        return ints.length > 0;
    }

    public List<Customer> query(String cname) throws Exception {
        DataSource dataSource = Utils.getdatasource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<Customer> list = queryRunner.query("select * from customer where cname like ?", new BeanListHandler<Customer>(Customer.class), "%" + cname + "%");
        return list;
    }
}
