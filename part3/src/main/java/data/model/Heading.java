package data.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Entity
@Component
public class Heading {
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

    public String getIntitule(){
        return intitule;
    }

    public void setIntitule(String inti){
        this.intitule = inti;
    }

    public String toString(){
        return this.intitule;
    }
}
