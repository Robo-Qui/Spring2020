package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.RendezVous;
import com.taa.project.scheduler.data.repository.RendezVousRepository;
import com.taa.project.scheduler.services.interfaces.IRendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezVousService implements IRendezVousService {
    private final RendezVousRepository repository;


    @Autowired
    public RendezVousService(RendezVousRepository repo) {
        this.repository = repo;
    }

    @Override
    public RendezVous add(RendezVous rdv) {
        repository.save(rdv);
        return rdv;
    }

}
