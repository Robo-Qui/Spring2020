package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.Heading;
import com.taa.project.scheduler.data.repository.HeadingRepository;
import com.taa.project.scheduler.services.interfaces.IHeadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadingService implements IHeadingService {
    private final HeadingRepository repository;

    @Autowired
    public HeadingService(HeadingRepository repo) {
        this.repository = repo;
    }

    @Override
    public List<Heading> add(List<Heading> intitules) {
        for (Heading intitule : intitules) {
            repository.save(intitule);
        }
        return intitules;
    }
}
