package com.poly.interractive3dvirtualtours.project;

import com.poly.interractive3dvirtualtours.payment.Payment;
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

import java.math.BigInteger;
import java.util.Arrays;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/project")
    private ResponseEntity getProjects(Model model,
                                       @RequestParam(defaultValue = "0") Integer currentPage,
                                       @RequestParam(defaultValue = "10") Integer recordsPerPage,
                                       @RequestParam(defaultValue = "id") String sortBy){
        try{
            return new ResponseEntity<>( projectRepository.findAll(PageRequest.of(currentPage, recordsPerPage, Sort.by(Arrays.asList(Sort.Order.desc(sortBy))))), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/project")
    private ResponseEntity saveToRegister(@RequestBody Project project)
    {
        try{
            projectRepository.saveAndFlush(project);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/project/{id}")
    private ResponseEntity single(@PathVariable("id") Integer id)
    {
        try{
            return new ResponseEntity<>(projectRepository.findById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/project/delete/{id}")
    private ResponseEntity delete(@PathVariable("id") Integer id)
    {
        try{
            Project project= new Project();
            project.setId(id);
            projectRepository.delete(project);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }
}
