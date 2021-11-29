package com.taa.project.scheduler.services.dto;

import java.util.Date;

public class FreeSlotDto {
    private Date startTime;
    private Date endTime;

    public FreeSlotDto() {
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
