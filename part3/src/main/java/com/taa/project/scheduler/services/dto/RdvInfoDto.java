package com.taa.project.scheduler.services.dto;

import java.util.List;

public class RdvInfoDto {
    private Long id;
    private int duree;
    private List<HeadingDto> intitules;

    public RdvInfoDto() {
    }

    public RdvInfoDto(int duree, List<HeadingDto> intitules) {
        this.duree = duree;
        this.intitules = intitules;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public List<HeadingDto> getIntitules() {
        return intitules;
    }

    public void setIntitules(List<HeadingDto> intitules) {
        this.intitules = intitules;
    }
}
