package com.taa.project.scheduler.services.dto;

public class HeadingDto {
    private Long id;
    private String label;

    public HeadingDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
