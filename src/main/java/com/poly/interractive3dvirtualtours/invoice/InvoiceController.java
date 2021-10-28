package com.poly.interractive3dvirtualtours.invoice;

import com.poly.interractive3dvirtualtours.register.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;
    @GetMapping("/invoice")
    private ResponseEntity getAll(Model model,
                                  @RequestParam(defaultValue = "0") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer recordsPerPage,
                                  @RequestParam(defaultValue = "id") String sortBy)
    {
        try{
            return new ResponseEntity<>( invoiceRepository.findAll(PageRequest.of(currentPage, recordsPerPage, Sort.by(Arrays.asList(Sort.Order.desc(sortBy))))), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/invoice/{id}")
    private ResponseEntity single(@PathVariable("id") int id)
    {
        try{
            return new ResponseEntity<>(invoiceRepository.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/invoice")
    private ResponseEntity saveToRegister(@RequestBody Invoice invoice)
    {
        try{
            invoiceRepository.saveAndFlush(invoice);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/invoice/delete/{id}")
    private ResponseEntity delete(@PathVariable("id") int id)
    {
        try{
            Invoice invoice= new Invoice();
            invoice.setId(id);
            invoiceRepository.delete(invoice);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }
}
