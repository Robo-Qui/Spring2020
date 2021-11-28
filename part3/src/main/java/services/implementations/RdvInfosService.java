package services.implementations;

import data.model.RdvInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import data.repository.RdvInfosRepository;

@Service
public class RdvInfosService {
    private final RdvInfosRepository repository;
    private HeadingService headingService;

    @Autowired
    public RdvInfosService(RdvInfosRepository repo, HeadingService headingService){
        this.repository = repo;
        this.headingService = headingService;
    }

    public RdvInfos add(RdvInfos rdvInfos) {
        rdvInfos.setIntitules(headingService.add(rdvInfos.getIntitules()));
        repository.save(rdvInfos);
        return rdvInfos;
    }
}
