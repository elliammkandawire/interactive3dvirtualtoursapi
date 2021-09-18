package com.poly.interractive3dvirtualtours.register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//mark class as Controller
@RestController
public class RegisterController
{
    @Autowired
    RegisterService registerService;

    //get all registered
    @GetMapping("/register")
    private ResponseEntity getAll()
    {
        List<Register> agents = new ArrayList<>();
        try{
            agents=registerService.getAll();
            return new ResponseEntity<>(agents, HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    //select a single registred person by id
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


    //posting new/edit person for register
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