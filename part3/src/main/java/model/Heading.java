package model;

import interfaces.IIntitule;
import org.springframework.stereotype.Component;

@Component
public class Heading implements IIntitule {
    private String intitule;
    private Long id;

    public Heading() {
    }

    public Heading(String intitule) {
        this.intitule = intitule;
    }

    public Long getId() {
        return id;
    }
    private void setId(Long id){
        this.id = id;
    }

    @Override
    public String getIntitule(){
        return intitule;
    }

    @Override
    public void setIntitule(String inti){
        this.intitule = inti;
    }

    public String toString(){
        return this.intitule;
    }
}
