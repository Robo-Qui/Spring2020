package com.taa.project.scheduler.services.dto;


import java.util.List;

public class ProfessionalDto extends AccountDto {
    private Long id;
    private String name;
    private RdvInfosDto infoRdv;
    private List<FreeSlotDto> freeSlots;
}
