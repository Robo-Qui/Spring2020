package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.RdvInfo;
import com.taa.project.scheduler.data.repository.RdvInfosRepository;
import com.taa.project.scheduler.services.interfaces.IRdvInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RdvInfosService implements IRdvInfosService {
    private final RdvInfosRepository repository;
    private HeadingService headingService;

    @Autowired
    public RdvInfosService(RdvInfosRepository repo, HeadingService headingService) {
        this.repository = repo;
        this.headingService = headingService;
    }

    public RdvInfo add(RdvInfo rdvInfos) {
        rdvInfos.setIntitules(headingService.add(rdvInfos.getIntitules()));
        repository.save(rdvInfos);
        return rdvInfos;
    }

    @Override
    public RdvInfo updateDuree(Long id, int duree) throws Exception {
        return null;
        //TODO
    }
}
