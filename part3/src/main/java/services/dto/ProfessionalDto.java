package services.dto;

import data.model.FreeSlot;
import data.model.RdvInfos;
import lombok.Data;

import java.util.List;

@Data
public class ProfessionalDto extends AccountDto{
    private Long id;
    private String name;
    private RdvInfosDto infoRdv;
    private List<FreeSlotDto> freeSlots;
}
