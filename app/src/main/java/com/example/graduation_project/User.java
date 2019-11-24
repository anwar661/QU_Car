package com.example.graduation_project;

public class User {
    public String name, email, phone, idnumber ;

    public User(){

    }

    public User(String name, String email, String phone, String idnumber) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idnumber= idnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
}

