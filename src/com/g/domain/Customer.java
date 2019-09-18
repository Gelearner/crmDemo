package com.g.domain;

import java.io.Serializable;

public class Customer implements Serializable {
    private String cid;
    private String cname;
    private int age;
    private String gender;
    private String email;
    private String telephone;
    private String description;

    public Customer() {
        super();
    }

    public Customer(String cid, String cname, int age, String gender,
                    String email, String telephone, String description) {
        super();
        this.cid = cid;
        this.cname = cname;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.telephone = telephone;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
