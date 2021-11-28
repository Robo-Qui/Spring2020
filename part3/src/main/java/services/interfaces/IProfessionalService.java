package services.interfaces;

import data.model.FreeSlot;
import data.model.Professional;
import data.model.RdvInfos;

import java.util.List;

public interface IProfessionalService {
    List<Professional> getAllProfessionals();

    Professional getById(Long id);

    Professional getByLogin(String login);

    Professional getByName(String name);

    List<FreeSlot> addFreeSlot(Long id, FreeSlot slot) throws Exception;

    List<FreeSlot> removeFreeSlot(Professional prof, FreeSlot slot);

    Professional addProfessionnel(Professional prof) throws Exception;

    Professional updateProfessional(long id, Professional professionalRequest) throws Exception;

    Professional changeProfRdvInfos(Professional prof, RdvInfos rdvInfos) throws Exception;

    void deleteProfessional(Long id) throws Exception;

}
