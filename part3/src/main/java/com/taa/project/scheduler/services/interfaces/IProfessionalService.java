package com.taa.project.scheduler.services.interfaces;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.model.Professional;
import com.taa.project.scheduler.data.model.RdvInfo;

import java.util.List;

public interface IProfessionalService {
    List<Professional> getAllProfessionals();

    Professional getById(Long id) throws Exception;

    Professional getByLogin(String login);

    Professional getByName(String name);

    List<FreeSlot> addFreeSlot(Long id, FreeSlot slot) throws Exception;

    List<FreeSlot> removeFreeSlot(Professional prof, FreeSlot slot);

    Professional addProfessionnel(Professional prof) throws Exception;

    Professional updateProfessional(long id, Professional professionalRequest) throws Exception;

    Professional changeProfRdvInfos(Professional prof, RdvInfo rdvInfos) throws Exception;

    void deleteProfessional(Long id) throws Exception;

}
