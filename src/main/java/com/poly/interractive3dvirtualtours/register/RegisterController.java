package com.poly.interractive3dvirtualtours.register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//mark class as Controller
@RestController
public class RegisterController
{
    @Autowired
    RegisterService registerService;

    @Autowired
    RegisterRepository registerRepository;

    @GetMapping("/register")
    private ResponseEntity getAll(Model model,
                                  @RequestParam(defaultValue = "0") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer recordsPerPage,
                                  @RequestParam(defaultValue = "id") String sortBy)
    {
        Page<Register> agents;
        try{
            agents=registerRepository.findAll(PageRequest.of(currentPage, recordsPerPage, Sort.by(Arrays.asList(Sort.Order.desc(sortBy)))));
            return new ResponseEntity<>(agents, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/register/{id}")
    private ResponseEntity getAgent(@PathVariable("id") int id)
    {
        Register agent;
        try{
            agent=registerService.getById(id);
            if(agent==null){
                return  new ResponseEntity<Error>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(agent, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/register")
    private ResponseEntity saveToRegister(@RequestBody Register register)
    {
        int registerId;
        try{
            registerService.saveOrUpdate(register);
            registerId=register.getId();
            if(registerId==0){
                return  new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

}