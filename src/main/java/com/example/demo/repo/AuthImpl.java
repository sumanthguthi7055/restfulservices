package com.example.demo.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AuthImpl
{
    @Id
    public String mail;
    public String pass;

    @Override
    public String toString() {
        return "AuthImpl{" +
                "mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
