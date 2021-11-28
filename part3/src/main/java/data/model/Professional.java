package data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
@Component
@NoArgsConstructor
public class Professional extends Account{
    private String name;

    @Autowired
    private RdvInfos infoRdv;

    @Autowired(required = false)
    private List<FreeSlot> freeSlots;

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
