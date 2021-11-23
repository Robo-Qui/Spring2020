package component;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RdvInfos {
    private int duree;
    private List<Intitule> intitules;
    private Long id;

    public RdvInfos() {
    }

    public RdvInfos(int duree, List<Intitule> intitules) {
        this.duree = duree;
        this.intitules = intitules;
    }

    public int getDuree(){
        return duree;
    }

    public void setDuree(int length){
        this.duree = length;
    }

    public List<Intitule> getIntitules() {
        return intitules;
    }

    public void setIntitules(List<Intitule> intitules) {
        this.intitules = intitules;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id){
        this.id = id;
    }
}
