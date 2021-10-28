package com.poly.interractive3dvirtualtours.services;

import com.poly.interractive3dvirtualtours.payment.Payment;
import com.poly.interractive3dvirtualtours.payment.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;

@Controller
public class ServicesController {
    @Autowired
    ServicesRepo servicesRepo;
    @GetMapping("/services")
    private ResponseEntity getAll(Model model,
                                  @RequestParam(defaultValue = "0") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer recordsPerPage,
                                  @RequestParam(defaultValue = "id") String sortBy)
    {
        try{
            return new ResponseEntity<>( servicesRepo.findAll(PageRequest.of(currentPage, recordsPerPage, Sort.by(Arrays.asList(Sort.Order.desc(sortBy))))), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/services/{id}")
    private ResponseEntity single(@PathVariable("id") BigInteger id)
    {
        try{
            return new ResponseEntity<>(servicesRepo.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/services")
    private ResponseEntity saveToRegister(@RequestBody Services service)
    {
        try{
            servicesRepo.saveAndFlush(service);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/services/delete/{id}")
    private ResponseEntity delete(@PathVariable("id") BigInteger id)
    {
        try{
            Services data= new Services();
            data.setId(id);
            servicesRepo.delete(data);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }
}
