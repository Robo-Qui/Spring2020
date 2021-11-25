package data.service.implementations;

import data.component.model.model.Heading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import data.repository.HeadingRepository;
import data.service.interfaces.IHeadingService;

import java.util.List;

@Service
public class HeadingService implements IHeadingService {
    private final HeadingRepository repository;

    @Autowired
    public HeadingService(HeadingRepository repo){
        this.repository = repo;
    }

    @Override
    public List<Heading> add(List<Heading> intitules) {
        for(Heading intitule : intitules){
            repository.save(intitule);
        }
        return intitules;
    }
}
