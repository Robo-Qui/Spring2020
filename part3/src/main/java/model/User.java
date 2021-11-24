package model;

import interfaces.IUser;
import org.springframework.stereotype.Component;

@Component
public class User extends Account implements IUser{

    public User(){
        super();
    }

    public User(String log, String pass){
        super(log,pass);
    }

}
