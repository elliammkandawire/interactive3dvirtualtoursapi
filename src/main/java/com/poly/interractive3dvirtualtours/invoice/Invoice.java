package com.poly.interractive3dvirtualtours.invoice;

import com.poly.interractive3dvirtualtours.register.Register;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "invoice")
public class Invoice {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Register project;

    @Column
    private int service_combo;

    @Column
    private BigDecimal total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Register getProject() {
        return project;
    }

    public void setProject(Register project) {
        this.project = project;
    }

    public int getService_combo() {
        return service_combo;
    }

    public void setService_combo(int service_combo) {
        this.service_combo = service_combo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
