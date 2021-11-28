package data.model;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
@Component
public class User extends Account{

    public User(){
        super();
    }

    public User(String log, String pass){
        super(log,pass);
    }

}
