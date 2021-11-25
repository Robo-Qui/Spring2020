package data.component.model.model;

import data.component.interfaces.IHeading;
import data.component.interfaces.IRdvInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RdvInfos implements IRdvInfos {
    private int duree;

    @Autowired
    private List<IHeading> intitules;

    private Long id;

    public RdvInfos() {
    }

    public RdvInfos(int duree, List<IHeading> intitules) {
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
    public List<IHeading> getIntitules() {
        return intitules;
    }
    @Autowired
    @Override
    public void setIntitules(List<IHeading> intitules) {
        this.intitules = intitules;
    }

    public Long getId() {
        return id;
    }
    private void setId(Long id){
        this.id = id;
    }
}
