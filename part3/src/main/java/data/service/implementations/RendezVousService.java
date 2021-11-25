package data.service.implementations;

import data.component.model.model.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import data.repository.RendezVousRepository;
import data.service.interfaces.IRendezVousService;

@Service
public class RendezVousService implements IRendezVousService {
    private final RendezVousRepository repository;


    @Autowired
    public RendezVousService(RendezVousRepository repo){
        this.repository = repo;
    }

    @Override
    public RendezVous add(RendezVous rdv){
        repository.save(rdv);
        return rdv;
    }

}
