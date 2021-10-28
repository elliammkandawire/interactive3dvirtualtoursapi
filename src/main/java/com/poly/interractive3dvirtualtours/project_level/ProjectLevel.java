package com.poly.interractive3dvirtualtours.project_level;

import com.poly.interractive3dvirtualtours.project.Project;

import javax.persistence.*;
import java.math.BigInteger;

@Entity(name="project_level_selection")
public class ProjectLevel {
    @Id
    @Column(name = "level_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;


    @ManyToOne
    @JoinColumn(name = "prj_id")
    private Project project;


    @Column
    private int service_combo;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getService_combo() {
        return service_combo;
    }

    public void setService_combo(int service_combo) {
        this.service_combo = service_combo;
    }
}
