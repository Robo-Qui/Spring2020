package model;

import interfaces.IAccount;
import org.springframework.stereotype.Component;

@Component
public class Compte implements IAccount {
    private Long Id;
    private String login;
    private String password;

    public Compte(){

    }

    public Compte(String log, String pass){
        login = log;
        password = pass;
    }

    public Long getId() {
        return Id;
    }

    private void setId(Long id){
        this.Id = id;
    }

    @Override
    public String getLogin() {
        return login;
    }
    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String ToString(){
        return String.format("Compte, login:%s password:%s",this.login,this.password);
    }
}
