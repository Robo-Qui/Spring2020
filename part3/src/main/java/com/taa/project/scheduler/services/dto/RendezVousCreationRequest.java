package com.taa.project.scheduler.services.dto;

public class RendezVousCreationRequest {
    private RendezVousDto rendezVous;
    private Long professional_id;
    private Long user_id;
    private Long freeslot_id;

    public RendezVousCreationRequest(RendezVousDto rendezVous, Long professional_id, Long user_id, Long freeslot_id) {
        this.rendezVous = rendezVous;
        this.professional_id = professional_id;
        this.user_id = user_id;
        this.freeslot_id = freeslot_id;
    }

    public RendezVousDto getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVousDto rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Long getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(Long professional_id) {
        this.professional_id = professional_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getFreeslot_id() {
        return freeslot_id;
    }

    public void setFreeslot_id(Long freeslot_id) {
        this.freeslot_id = freeslot_id;
    }
}
