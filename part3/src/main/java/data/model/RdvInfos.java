package data.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Component
public class RdvInfos {
    private int duree;

    @Autowired
    private List<Heading> intitules;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RdvInfos() {
    }

    public RdvInfos(int duree, List<Heading> intitules) {
        this.duree = duree;
        this.intitules = intitules;
    }

    public int getDuree(){
        return duree;
    }
    public void setDuree(int length){
        this.duree = length;
    }

    public List<Heading> getIntitules() {
        return intitules;
    }
    @Autowired
    public void setIntitules(List<Heading> intitules) {
        this.intitules = intitules;
    }

    public Long getId() {
        return id;
    }
    private void setId(Long id){
        this.id = id;
    }
}
