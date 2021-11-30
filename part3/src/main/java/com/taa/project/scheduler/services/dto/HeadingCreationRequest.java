package com.taa.project.scheduler.services.dto;

public class HeadingCreationRequest {

    private Long rdvInfoId;
    private HeadingDto heading;

    public HeadingCreationRequest(Long rdvInfoId, HeadingDto heading) {
        this.rdvInfoId = rdvInfoId;
        this.heading = heading;
    }

    public Long getRdvInfoId() {
        return rdvInfoId;
    }

    public void setRdvInfoId(Long rdvInfoId) {
        this.rdvInfoId = rdvInfoId;
    }

    public HeadingDto getHeading() {
        return heading;
    }

    public void setHeading(HeadingDto heading) {
        this.heading = heading;
    }
}


