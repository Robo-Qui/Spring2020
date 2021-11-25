package data.service.implementations;

import data.component.model.model.RdvInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import data.repository.RdvInfosRepository;
import data.service.interfaces.IRdvInfosService;

@Service
public class RdvInfosService implements IRdvInfosService {
    private final RdvInfosRepository repository;
    private HeadingService headingService;

    @Autowired
    public RdvInfosService(RdvInfosRepository repo, HeadingService headingService){
        this.repository = repo;
        this.headingService = headingService;
    }

    @Override
    public RdvInfos add(RdvInfos rdvInfos) {
        rdvInfos.setIntitules(headingService.add(rdvInfos.getIntitules()));
        repository.save(rdvInfos);
        return rdvInfos;
    }
}
