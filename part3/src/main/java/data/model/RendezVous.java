package data.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Component
public class RendezVous {
    @Autowired
    private Professional prof;
    @Autowired
    private User client;
    private Date startTime;
    private Date endTime;
    private Long id;

    public RendezVous() {
    }

    public RendezVous(Professional prof, User client, Date startTime, Date endTime) {
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

    public Professional getProf() {
        return prof;
    }
    @Autowired
    public void setProf(Professional prof) {
        this.prof = prof;
    }

    public User getClient() {
        return client;
    }
    @Autowired
    public void setClient(User client) {
        this.client = client;
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
