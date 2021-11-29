package com.taa.project.scheduler.services.dto;

import com.taa.project.scheduler.data.model.Professional;

import java.util.Date;

public class FreeSlotDto {
    private Long id;
    private Date startTime;
    private Date endTime;
    private Long professionalId;

    public FreeSlotDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Professional professional) {
        this.professionalId = professional.getId();
    }
}
