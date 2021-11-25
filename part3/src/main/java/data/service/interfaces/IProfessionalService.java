package data.service.interfaces;

import data.component.model.model.FreeSlot;
import data.component.model.model.Professional;
import data.component.model.model.RdvInfos;

import java.util.List;

public interface IProfessionalService {
    Professional getById(Long id);

    Professional getByLogin(String login);

    Professional getByName(String name);

    List<FreeSlot> addFreeSlot(Long id, FreeSlot slot) throws Exception;

    List<FreeSlot> removeFreeSlot(Professional prof, FreeSlot slot);

    Professional addProfessionnel(Professional prof) throws Exception;

    Professional changeProfRdvInfos(Professional prof, RdvInfos rdvInfos) throws Exception;
}
