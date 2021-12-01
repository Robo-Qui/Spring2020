package com.taa.project.scheduler.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rdvinfo")
public class RdvInfo {

    private Long id;
    private int duree;
    private List<Heading> intitules;


    public RdvInfo() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rdvinfo_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "rdvinfo_duration")
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @OneToMany(mappedBy = "rendezVousList")
    public List<Heading> getIntitules() {
        return intitules;
    }

    public void setIntitules(List<Heading> intitules) {
        this.intitules = intitules;
    }
}
