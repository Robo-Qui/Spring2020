package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.model.Professional;
import com.taa.project.scheduler.data.model.RdvInfo;
import com.taa.project.scheduler.data.repository.ProfessionalRepository;
import com.taa.project.scheduler.services.interfaces.IFreeSlotService;
import com.taa.project.scheduler.services.interfaces.IProfessionalService;
import com.taa.project.scheduler.services.interfaces.IRdvInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService implements IProfessionalService {
    private final ProfessionalRepository repository;
    private IFreeSlotService freeSlotService;
    private IRdvInfosService rdvInfosService;

    @Autowired
    public ProfessionalService(ProfessionalRepository repo, IFreeSlotService freeSlotService, IRdvInfosService rdvInfosService) {
        this.repository = repo;
        this.freeSlotService = freeSlotService;
        this.rdvInfosService = rdvInfosService;
    }

    @Override
    public List<Professional> getAllProfessionals() {
        return repository.findAll();
    }

    @Override
    public Professional getById(Long id) throws Exception {
        try {
            return repository.getProfessionalById(id);
        } catch (Exception e) {
            throw new Exception("Can't retrieve this professional.");
        }
    }

    @Override
    public Professional getByLogin(String login) {
        return repository.getProfessionalByLogin(login);
    }

    @Override
    public Professional getByName(String name) {
        return repository.getProfessionalByName(name);
    }

    @Override
    public List<FreeSlot> addFreeSlot(Long id, FreeSlot slot) throws Exception {
        Professional prof = getById(id);
        if (prof != null && slot.getStartTime().before(slot.getEndTime())) {
            //prof.setFreeSlots(freeSlotService.add(slot, prof.getId()));
            //TODO: fix
            repository.save(prof);
            return prof.getFreeSlots();
        } else {
            throw new Exception("Account not found or startime must be before endtime");
        }
    }

    @Override
    public List<FreeSlot> removeFreeSlot(Professional prof, FreeSlot slot) {
        //remove from freeslots
        //freeSlotService.remove(prof, slot);
        //TODO
        repository.save(prof);
        return prof.getFreeSlots();
    }

    @Override
    public Professional addProfessionnel(Professional prof) throws Exception {
        //if login and name don't exist yet
        if (getByName(prof.getName()) == null && getByLogin(prof.getLogin()) == null) {
            repository.save(prof);
            return prof;
        } else {
            throw new Exception("Ce professionnel existe déjà");
        }
    }

    @Override
    public Professional updateProfessional(long id, Professional professionalRequest) throws Exception {
        Professional professional = repository.findById(id)
                .orElseThrow(() -> new Exception("Professional not found"));
        professional.setLogin(professionalRequest.getLogin());
        professional.setPassword(professionalRequest.getPassword());
        professional.setName(professionalRequest.getName());
        return repository.save(professional);
    }

    @Override
    public Professional changeProfRdvInfos(Professional prof, RdvInfo rdvInfos) throws Exception {
        if (getById(prof.getId()) != null) {
            prof.setInfoRdv(rdvInfosService.add(rdvInfos));
            return prof;
        } else {
            throw new Exception("Professionnel inexistant");
        }
    }

    @Override
    public void deleteProfessional(Long id) throws Exception {
        Professional professional = repository.findById(id)
                .orElseThrow(() -> new Exception("Professional not found"));
        repository.delete(professional);

    }

}
