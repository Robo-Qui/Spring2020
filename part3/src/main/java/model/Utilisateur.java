package model;

import interfaces.IUser;
import org.springframework.stereotype.Component;

@Component
public class Utilisateur extends Compte implements IUser{

    public Utilisateur(){
        super();
    }

    public Utilisateur(String log, String pass){
        super(log,pass);
    }

}
