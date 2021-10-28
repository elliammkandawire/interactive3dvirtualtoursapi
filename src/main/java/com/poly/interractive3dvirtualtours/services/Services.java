package com.poly.interractive3dvirtualtours.services;

import com.poly.interractive3dvirtualtours.project_level.ProjectLevel;

import javax.persistence.*;
import java.math.BigInteger;

@Entity(name = "services")
public class Services {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private String type;

    @Column
    private String presentation;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private ProjectLevel level;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public ProjectLevel getLevel() {
        return level;
    }

    public void setLevel(ProjectLevel level) {
        this.level = level;
    }
}
