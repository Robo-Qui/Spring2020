package com.taa.project.scheduler.services.dto;

import java.util.Date;

public class RendezVousDto {
    private ProfessionalDto prof;
    private UserDto client;
    private Date startTime;
    private Date endTime;

    public RendezVousDto() {
    }

    public ProfessionalDto getProf() {
        return prof;
    }

    public void setProf(ProfessionalDto prof) {
        this.prof = prof;
    }

    public UserDto getClient() {
        return client;
    }

    public void setClient(UserDto client) {
        this.client = client;
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
}
