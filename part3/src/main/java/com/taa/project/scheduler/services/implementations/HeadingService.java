package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.Heading;
import com.taa.project.scheduler.data.model.RdvInfo;
import com.taa.project.scheduler.data.repository.HeadingRepository;
import com.taa.project.scheduler.data.repository.RdvInfosRepository;
import com.taa.project.scheduler.services.interfaces.IHeadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadingService implements IHeadingService {
    private final HeadingRepository headingRepository;
    private final RdvInfosRepository rdvInfosRepository;

    @Autowired
    public HeadingService(HeadingRepository headingRepository, RdvInfosRepository rdvInfosRepository) {
        this.headingRepository = headingRepository;
        this.rdvInfosRepository = rdvInfosRepository;
    }

    @Override
    public List<Heading> add(List<Heading> intitules) {
        for (Heading intitule : intitules) {
            headingRepository.save(intitule);
        }
        return intitules;
    }

    @Override
    public Heading createHeading(Heading heading, Long rdvInfoId) {
        //Persist heading
        heading = headingRepository.save(heading);

        //Add to a rdvinfo
        //Get rdvInfo
        RdvInfo rdvInfo = rdvInfosRepository.getById(rdvInfoId);
        //Get his headings
        List<Heading> intitules = rdvInfo.getIntitules();
        intitules.add(heading);

        // add to list for rdvinfos
        intitules.add(heading);
        rdvInfo.setIntitules(intitules);
        //persist
        rdvInfosRepository.save(rdvInfo);

        return heading;
    }

}
