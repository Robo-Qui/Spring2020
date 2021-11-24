package component;

import interfaces.IIntitule;
import interfaces.IRdvInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RdvInfos implements IRdvInfos {
    private int duree;

    @Autowired
    private List<IIntitule> intitules;

    private Long id;

    public RdvInfos() {
    }

    public RdvInfos(int duree, List<IIntitule> intitules) {
        this.duree = duree;
        this.intitules = intitules;
    }

    @Override
    public int getDuree(){
        return duree;
    }
    @Override
    public void setDuree(int length){
        this.duree = length;
    }

    @Override
    public List<IIntitule> getIntitules() {
        return intitules;
    }
    @Autowired
    @Override
    public void setIntitules(List<IIntitule> intitules) {
        this.intitules = intitules;
    }

    public Long getId() {
        return id;
    }
    private void setId(Long id){
        this.id = id;
    }
}
