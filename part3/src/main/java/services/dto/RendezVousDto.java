package services.dto;

import data.model.Professional;
import data.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class RendezVousDto {
    private ProfessionalDto prof;
    private UserDto client;
    private Date startTime;
    private Date endTime;
}
