package com.taa.project.scheduler.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "heading")
public class Heading {

    private Long id;
    private String label;
    private RdvInfo rdvInfo;
    private List<RendezVous> rendezVousList;

    public Heading() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heading_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "heading_label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @ManyToOne
    @JoinColumn(name = "rdvinfo_id")
    public RdvInfo getRdvInfo() {
        return rdvInfo;
    }

    public void setRdvInfo(RdvInfo rdvInfo) {
        this.rdvInfo = rdvInfo;
    }

    @OneToMany(mappedBy = "heading")
    public List<RendezVous> getRendezVousList() {
        return rendezVousList;
    }

    public void setRendezVousList(List<RendezVous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }

    public String toString() {
        return this.label;
    }
}
