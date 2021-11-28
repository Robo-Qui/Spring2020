package services.implementations;

import data.model.FreeSlot;
import data.model.Professional;
import data.model.RdvInfos;
import data.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.interfaces.IFreeSlotService;
import services.interfaces.IProfessionalService;
import services.interfaces.IRdvInfosService;

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
    public Professional getById(Long id) {
        return repository.getProfessionalById(id);
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
            prof.setFreeSlots(freeSlotService.add(slot, prof.getFreeSlots()));
            repository.update(prof);
            return prof.getFreeSlots();
        } else {
            throw new Exception("Account not found or startime must be before endtime");
        }
    }

    @Override
    public List<FreeSlot> removeFreeSlot(Professional prof, FreeSlot slot) {
        prof.setFreeSlots(freeSlotService.remove(prof.getFreeSlots(), slot));
        repository.update(prof);
        return prof.getFreeSlots();
    }

    @Override
    public Professional addProfessionnel(Professional prof) throws Exception {
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
        return repository.save(professional);
    }

    @Override
    public Professional changeProfRdvInfos(Professional prof, RdvInfos rdvInfos) throws Exception {
        if (getById(prof.getId()) != null) {
            prof.setRdvInfos(rdvInfosService.add(rdvInfos));
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
