package com.taa.project.scheduler.services.interfaces;

import com.taa.project.scheduler.data.model.FreeSlot;

public interface IFreeSlotService {
    FreeSlot add(FreeSlot slot, Long profId) throws Exception;

    void remove(Long id);

    FreeSlot getById(Long freeSlotId);


}
