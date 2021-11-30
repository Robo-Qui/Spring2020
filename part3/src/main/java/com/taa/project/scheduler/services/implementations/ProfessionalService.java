package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.model.Professional;
import com.taa.project.scheduler.data.model.RdvInfo;
import com.taa.project.scheduler.data.model.RendezVous;
import com.taa.project.scheduler.data.repository.ProfessionalRepository;
import com.taa.project.scheduler.services.interfaces.IFreeSlotService;
import com.taa.project.scheduler.services.interfaces.IProfessionalService;
import com.taa.project.scheduler.services.interfaces.IRdvInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Professional addProfessionnel(Professional prof) throws Exception {
        try {
            //if login and name don't exist yet
            if (getByName(prof.getName()) == null && getByLogin(prof.getLogin()) == null) {
                prof.setFreeSlots(new ArrayList<FreeSlot>());
                prof.setRendezVousList(new ArrayList<RendezVous>());
                prof.setInfoRdv(new RdvInfo());
                prof = repository.save(prof);
                return prof;
            } else {
                throw new Exception("Ce professionnel existe déjà");

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ne peux pas ajouter ce professionel");

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
