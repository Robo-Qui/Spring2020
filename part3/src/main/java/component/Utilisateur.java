package component;

import org.springframework.stereotype.Component;

@Component
public class Utilisateur extends Compte{

    public Utilisateur(){
        super();
    }

    public Utilisateur(String log, String pass){
        super(log,pass);
    }
}
