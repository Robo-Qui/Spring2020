package component;

import org.springframework.stereotype.Component;

@Component
public class Compte {
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

    public String ToString(){
        return String.format("Compte, login:%s password:%s",this.login,this.password);
    }
}
