package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.model.Professional;
import com.taa.project.scheduler.data.model.RendezVous;
import com.taa.project.scheduler.data.model.User;
import com.taa.project.scheduler.data.repository.RendezVousRepository;
import com.taa.project.scheduler.services.interfaces.IFreeSlotService;
import com.taa.project.scheduler.services.interfaces.IProfessionalService;
import com.taa.project.scheduler.services.interfaces.IRendezVousService;
import com.taa.project.scheduler.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezVousService implements IRendezVousService {
    private final RendezVousRepository repository;
    private IUserService userService;
    private IProfessionalService professionalService;
    private IFreeSlotService freeSlotService;


    @Autowired
    public RendezVousService(RendezVousRepository repository, IUserService userService, IProfessionalService professionalService, IFreeSlotService freeSlotService) {
        this.repository = repository;
        this.userService = userService;
        this.professionalService = professionalService;
        this.freeSlotService = freeSlotService;
    }

    @Override
    public RendezVous add(Long utilId, Long profId, Long freeSlotId) throws Exception {
        User user = userService.getById(utilId);
        Professional professional = professionalService.getById(profId);
        FreeSlot freeSlot = freeSlotService.getById(freeSlotId);
        RendezVous rendezVous = new RendezVous(user, professional, null, freeSlot.getStartTime(), freeSlot.getEndTime());
        repository.save(rendezVous);
        freeSlotService.remove(freeSlotId);
        return rendezVous;
    }

    @Override
    public void remove(Long id) throws Exception {
        RendezVous rendezVous = repository.findById(id)
                .orElseThrow(() -> new Exception("RendezVous not found"));
        repository.delete(rendezVous);
    }
}
