package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name = "auth_details")
public class UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="user_id")
        private int id;
        @Column(name="email")
        private String email;
        @Column(name="password")
        private int password;

    public UserDetails(int id, String email, int password) {

        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserDetails() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
