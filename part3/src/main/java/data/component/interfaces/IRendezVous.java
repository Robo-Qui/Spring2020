package data.component.interfaces;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public interface IRendezVous {
    IProfessionnal getProf();

    @Autowired
    void setProf(IProfessionnal prof);

    IUser getClient();

    @Autowired
    void setClient(IUser client);

    Date getStartTime();

    void setStartTime(Date startTime);

    Date getEndTime();

    void setEndTime(Date endTime);
}
