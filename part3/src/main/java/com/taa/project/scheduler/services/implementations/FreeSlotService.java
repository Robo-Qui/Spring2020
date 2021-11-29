package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.repository.FreeSlotRepository;
import com.taa.project.scheduler.services.interfaces.IFreeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FreeSlotService implements IFreeSlotService {
    private final FreeSlotRepository repository;

    //private IProfessionalService professionalService;

    @Autowired
    public FreeSlotService(FreeSlotRepository repository/*, IProfessionalService professionalService*/) {
        this.repository = repository;
        //this.professionalService = professionalService;
    }

    @Override
    public FreeSlot add(FreeSlot slot, Long id) throws Exception {
        /*List<FreeSlot> slots = professionalService.getById(id).getFreeSlots();
        for (FreeSlot sl : slots) {
            //si chevauchement
            if (slot.getStartTime().after(sl.getStartTime()) && slot.getStartTime().before(sl.getEndTime()) ||
                    slot.getEndTime().before(sl.getEndTime()) && slot.getEndTime().after(sl.getStartTime())) {
                throw new Exception("Chevauchement de slots");
            }
        }
        repository.save(slot);
        slots.add(slot);*/
        return slot;
    }


    @Override
    public void remove(Long id) {
        FreeSlot slot = repository.getById(id);
        repository.delete(slot);
    }

    @Override
    public FreeSlot getById(Long freeSlotId) {
        return repository.getById(freeSlotId);
    }

}
