package com.taa.project.scheduler.services.implementations;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.repository.FreeSlotRepository;
import com.taa.project.scheduler.services.interfaces.IFreeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeSlotService implements IFreeSlotService {
    private final FreeSlotRepository repository;

    @Autowired
    public FreeSlotService(FreeSlotRepository repo) {
        this.repository = repo;
    }

    @Override
    public List<FreeSlot> add(FreeSlot slot, List<FreeSlot> slots) {
        for (FreeSlot sl : slots) {
            //si chevauchement
            if (slot.getStartTime().after(sl.getStartTime()) && slot.getStartTime().before(sl.getEndTime()) ||
                    slot.getEndTime().before(sl.getEndTime()) && slot.getEndTime().after(sl.getStartTime())) {
                return slots;
            }
        }
        repository.save(slot);
        slots.add(slot);
        return slots;
    }

    @Override
    public List<FreeSlot> remove(List<FreeSlot> slots, FreeSlot slot) {
        slots.remove(slot);
        return slots;
    }

}
