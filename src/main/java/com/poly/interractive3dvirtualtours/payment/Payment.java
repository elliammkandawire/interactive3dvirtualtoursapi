package com.poly.interractive3dvirtualtours.payment;

import com.poly.interractive3dvirtualtours.invoice.Invoice;
import com.poly.interractive3dvirtualtours.project.Project;
import com.poly.interractive3dvirtualtours.register.Register;

import javax.persistence.*;
import java.math.BigInteger;

@Entity(name = "payment")
public class Payment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name="payment_mode")
    private String payment_mode;

    @Column
    private String proof_of_payment;

    @ManyToOne
    @JoinColumn(name = "prj_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "invoice_number")
    private Invoice invoice;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public String getProof_of_payment() {
        return proof_of_payment;
    }

    public void setProof_of_payment(String proof_of_payment) {
        this.proof_of_payment = proof_of_payment;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
