package com.poly.interractive3dvirtualtours.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface ServicesRepo extends JpaRepository<Services, BigInteger> {
}
