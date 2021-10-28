package com.poly.interractive3dvirtualtours.payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PaymentRepository extends JpaRepository<Payment, BigInteger> {
}
