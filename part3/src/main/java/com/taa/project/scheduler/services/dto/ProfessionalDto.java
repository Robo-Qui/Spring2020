package com.taa.project.scheduler.services.dto;


import java.util.List;

public class ProfessionalDto extends AccountDto {
    private Long id;
    private String name;
    private RdvInfoDto infoRdv;
    private List<FreeSlotDto> freeSlots;

    public ProfessionalDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RdvInfoDto getInfoRdv() {
        return infoRdv;
    }

    public void setInfoRdv(RdvInfoDto infoRdv) {
        this.infoRdv = infoRdv;
    }

    public List<FreeSlotDto> getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(List<FreeSlotDto> freeSlots) {
        this.freeSlots = freeSlots;
    }
}
