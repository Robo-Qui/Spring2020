package model;

import interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Professionnel extends Compte implements IProfessionnal{
    private String name;

    @Autowired
    IRdvInfos infoRdv;

    @Autowired(required = false)
    List<IFreeSlot> freeSlots;

    public Professionnel() {
        super();
    }

    public Professionnel(String log, String pass, String name){
        super(log,pass);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Autowired
    public IRdvInfos getRdvInfos() {
        return infoRdv;
    }
    @Override
    public void setRdvInfos(RdvInfos rdvInfo) {
        this.infoRdv = rdvInfo;
    }

    @Override
    @Autowired
    public List<IFreeSlot> getFreeSlots() {
        return freeSlots;
    }
    @Override
    @Autowired
    public void setFreeSlots(List<IFreeSlot> freeSlots) {
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
    private String IntiList(List<IIntitule> intitules){
        if(intitules==null) return "Aucun intitulé";
        String res = "Liste des intitulés:";
        for(IIntitule intitule : intitules){
            res = String.format("%s\n%s",res,intitule.toString());
        }
        return res;
    }
}
