package com.taa.project.scheduler.data.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends Account {

    public User() {
        super();
    }

    private List<RendezVous> rendezVousList;

    @OneToMany
    @JoinTable(inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<RendezVous> getRendezVousList() {
        return rendezVousList;
    }

    public void setRendezVousList(List<RendezVous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }
}
