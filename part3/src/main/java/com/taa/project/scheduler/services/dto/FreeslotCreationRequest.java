package com.taa.project.scheduler.services.dto;

public class FreeslotCreationRequest {

    private Long professional_id;
    private FreeSlotDto freeSlot;

    public FreeslotCreationRequest(Long professional_id, FreeSlotDto freeSlot) {
        this.professional_id = professional_id;
        this.freeSlot = freeSlot;
    }

    public Long getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(Long professional_id) {
        this.professional_id = professional_id;
    }

    public FreeSlotDto getFreeSlotDto() {
        return freeSlot;
    }

    public void setFreeSlotDto(FreeSlotDto freeSlotDto) {
        this.freeSlot = freeSlotDto;
    }
}
