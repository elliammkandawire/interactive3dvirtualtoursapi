package com.poly.interractive3dvirtualtours.payment;

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
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;
    @GetMapping("/payment")
    private ResponseEntity getAll(Model model,
                                  @RequestParam(defaultValue = "0") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer recordsPerPage,
                                  @RequestParam(defaultValue = "id") String sortBy)
    {
        try{
            return new ResponseEntity<>( paymentRepository.findAll(PageRequest.of(currentPage, recordsPerPage, Sort.by(Arrays.asList(Sort.Order.desc(sortBy))))), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/payment/{id}")
    private ResponseEntity single(@PathVariable("id") BigInteger id)
    {
        try{
            return new ResponseEntity<>(paymentRepository.findById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/payment")
    private ResponseEntity saveToRegister(@RequestBody Payment payment)
    {
        try{
            paymentRepository.saveAndFlush(payment);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/payment/delete/{id}")
    private ResponseEntity delete(@PathVariable("id") BigInteger id)
    {
        try{
            Payment pay= new Payment();
            pay.setId(id);
            paymentRepository.delete(pay);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }
}
