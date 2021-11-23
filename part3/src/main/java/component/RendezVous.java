package component;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RendezVous {
    private Professionnel prof;
    private Utilisateur client;
    private Date startTime;
    private Date endTime;
    private Long id;

    public RendezVous() {
    }

    public RendezVous(Professionnel prof, Utilisateur client, Date startTime, Date endTime) {
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

    public Professionnel getProf() {
        return prof;
    }

    public void setProf(Professionnel prof) {
        this.prof = prof;
    }

    public Utilisateur getClient() {
        return client;
    }

    public void setClient(Utilisateur client) {
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
