package com.poly.interractive3dvirtualtours.project;

import com.poly.interractive3dvirtualtours.register.Register;

import javax.persistence.*;

@Entity(name="project")
public class Project {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="project_name")
    private String project_name;

    @ManyToOne
    @JoinColumn(name = "project_owner")
    private Register owner;

    @Column(name="purpose")
    private String purpose;

    @Column(name="location")
    private String location;

    @Column(name="terrains")
    private String terrains;

    @Column(name="area")
    private String area;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTerrains() {
        return terrains;
    }

    public void setTerrains(String terrains) {
        this.terrains = terrains;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Register getOwner() {
        return owner;
    }

    public void setOwner(Register owner) {
        this.owner = owner;
    }
}
