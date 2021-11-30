package com.taa.project.scheduler.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professional extends Account {

    private String name;
    private RdvInfo infoRdv;
    private List<FreeSlot> freeSlots;
    private List<RendezVous> rendezVousList;

    public Professional() {
        super();
    }


    @Column(name = "professional_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public RdvInfo getInfoRdv() {
        return infoRdv;
    }

    public void setInfoRdv(RdvInfo infoRdv) {
        this.infoRdv = infoRdv;
    }

    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL)
    public List<FreeSlot> getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(List<FreeSlot> freeSlots) {
        this.freeSlots = freeSlots;
    }

    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL)
    public List<RendezVous> getRendezVousList() {
        return rendezVousList;
    }

    public void setRendezVousList(List<RendezVous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }

    @Override
    public String toString() {
        if (this.getInfoRdv() == null) return String.format("Professionnel %s", this.getName());
        return String.format("Profesionnel %s, Durée de RDV: %s\n%s\nCréneaux disponibles %s",
                this.name, this.getInfoRdv().getDuree(),
                IntiList(this.getInfoRdv().getIntitules()),
                this.freeSlots
        );
    }


    private String IntiList(List<Heading> intitules) {
        if (intitules == null) return "Aucun intitulé";
        String res = "Liste des intitulés:";
        for (Heading intitule : intitules) {
            res = String.format("%s\n%s", res, intitule.toString());
        }
        return res;
    }
}
