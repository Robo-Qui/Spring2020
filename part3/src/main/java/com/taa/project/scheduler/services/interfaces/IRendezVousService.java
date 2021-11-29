package com.taa.project.scheduler.services.interfaces;

import com.taa.project.scheduler.data.model.RendezVous;

public interface IRendezVousService {
    RendezVous add(Long utilId, Long profId, Long freeSlotId) throws Exception;

    void remove(Long id) throws Exception;
}
