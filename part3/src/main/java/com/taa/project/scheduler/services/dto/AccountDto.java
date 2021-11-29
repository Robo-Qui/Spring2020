package com.taa.project.scheduler.services.dto;


public class AccountDto {
    private String login;
    private String password;

    public AccountDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
