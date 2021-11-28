package services.dto;

import lombok.Data;

import java.util.Date;

@Data
public class FreeSlotDto {
    private Date startTime;
    private Date endTime;
}
