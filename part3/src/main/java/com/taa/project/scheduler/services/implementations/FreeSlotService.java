package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.repository.FreeSlotRepository;
import com.taa.project.scheduler.data.repository.ProfessionalRepository;
import com.taa.project.scheduler.services.interfaces.IFreeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FreeSlotService implements IFreeSlotService {
    private final FreeSlotRepository freeSlotRepository;

    private final ProfessionalRepository professionalRepository;

    @Autowired
    public FreeSlotService(FreeSlotRepository freeSlotRepository, ProfessionalRepository professionalRepository) {
        this.freeSlotRepository = freeSlotRepository;
        this.professionalRepository = professionalRepository;
    }

    @Override
    public FreeSlot add(FreeSlot slot) throws Exception {
        List<FreeSlot> slots = professionalRepository.getById(slot.getProfessional().getId()).getFreeSlots();
        for (FreeSlot sl : slots) {
            //si chevauchement
            if (slot.getStartTime().after(sl.getStartTime()) && slot.getStartTime().before(sl.getEndTime()) ||
                    slot.getEndTime().before(sl.getEndTime()) && slot.getEndTime().after(sl.getStartTime())) {
                throw new Exception("Chevauchement de slots");
            }
        }
        freeSlotRepository.save(slot);
        slots.add(slot);
        return slot;
    }


    @Override
    public void remove(Long id) {
        FreeSlot slot = freeSlotRepository.getById(id);
        freeSlotRepository.delete(slot);
    }

    @Override
    public FreeSlot getById(Long freeSlotId) {
        return freeSlotRepository.getById(freeSlotId);
    }

}
