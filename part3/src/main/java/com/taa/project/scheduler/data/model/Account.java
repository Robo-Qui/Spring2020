package com.taa.project.scheduler.data.model;

import javax.persistence.*;


@Entity
@Table(name = "account")
public class Account {

    private Long Id;
    private String login;
    private String password;

    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Column(name = "account_login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "account_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String ToString() {
        return String.format("Compte, login:%s password:%s", this.login, this.password);
    }
}
