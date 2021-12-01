package com.taa.project.scheduler.services.interfaces;

import com.taa.project.scheduler.data.model.RdvInfo;

public interface IRdvInfosService {
    RdvInfo add(RdvInfo rdvInfos);

    RdvInfo updateDuree(Long id, int duree) throws Exception;

}
