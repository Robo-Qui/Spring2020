package com.taa.project.scheduler.data.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rendezvous")
public class RendezVous {

    private Long id;
    private User user;
    private Professional professional;
    private Heading heading;
    private Date startTime;
    private Date endTime;


    public RendezVous() {
    }

    public RendezVous(User user, Professional professional, Heading heading, Date startTime, Date endTime) {
        this.user = user;
        this.professional = professional;
        this.heading = heading;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "professional_id")
    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    @ManyToOne
    @JoinColumn(name = "heading_id")
    public Heading getHeading() {
        return heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    @Column(name = "rendezvous_start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name = "rendezvous_end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
