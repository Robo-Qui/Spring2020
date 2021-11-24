package model;

import interfaces.IProfessionnal;
import interfaces.IRendezVous;
import interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RendezVous implements IRendezVous {
    @Autowired
    private IProfessionnal prof;
    @Autowired
    private IUser client;
    private Date startTime;
    private Date endTime;
    private Long id;

    public RendezVous() {
    }

    public RendezVous(IProfessionnal prof, IUser client, Date startTime, Date endTime) {
        this.prof = prof;
        this.client = client;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public IProfessionnal getProf() {
        return prof;
    }
    @Override
    @Autowired
    public void setProf(IProfessionnal prof) {
        this.prof = prof;
    }

    @Override
    public IUser getClient() {
        return client;
    }
    @Override
    @Autowired
    public void setClient(IUser client) {
        this.client = client;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }
    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }
    @Override
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
