package data.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Component
public class Professional extends Account{
    private String name;

    @Autowired
    RdvInfos infoRdv;

    @Autowired(required = false)
    List<FreeSlot> freeSlots;

    public Professional() {
        super();
    }

    public Professional(String log, String pass, String name){
        super(log,pass);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public RdvInfos getRdvInfos() {
        return infoRdv;
    }
    public void setRdvInfos(RdvInfos rdvInfo) {
        this.infoRdv = rdvInfo;
    }

    @Autowired
    public List<FreeSlot> getFreeSlots() {
        return freeSlots;
    }
    @Autowired
    public void setFreeSlots(List<FreeSlot> freeSlots) {
        this.freeSlots = freeSlots;
    }

    @Override
    public String toString(){
        if(this.getRdvInfos()==null) return String.format("Professionnel %s",this.getName());
        return String.format("Profesionnel %s, Durée de RDV: %s\n%s\nCréneaux disponibles %s",
                this.name,this.getRdvInfos().getDuree(),
                IntiList(this.getRdvInfos().getIntitules()),
                this.freeSlots
        );
    }

    @Autowired
    private String IntiList(List<Heading> intitules){
        if(intitules==null) return "Aucun intitulé";
        String res = "Liste des intitulés:";
        for(Heading intitule : intitules){
            res = String.format("%s\n%s",res,intitule.toString());
        }
        return res;
    }
}
