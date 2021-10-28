package com.poly.interractive3dvirtualtours.project_level;

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
public class ProjectLevelController {
    @Autowired
    ProjectLevelRepo projectLevelRepo;
    @GetMapping("/project_level")
    private ResponseEntity getAll(Model model,
                                  @RequestParam(defaultValue = "0") Integer currentPage,
                                  @RequestParam(defaultValue = "10") Integer recordsPerPage,
                                  @RequestParam(defaultValue = "id") String sortBy)
    {
        try{
            return new ResponseEntity<>( projectLevelRepo.findAll(PageRequest.of(currentPage, recordsPerPage, Sort.by(Arrays.asList(Sort.Order.desc(sortBy))))), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/project_level/{id}")
    private ResponseEntity single(@PathVariable("id") BigInteger id)
    {
        try{
            return new ResponseEntity<>(projectLevelRepo.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/project_level")
    private ResponseEntity saveToRegister(@RequestBody ProjectLevel data)
    {
        try{
            projectLevelRepo.saveAndFlush(data);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/project_level/delete/{id}")
    private ResponseEntity delete(@PathVariable("id") BigInteger id)
    {
        try{
            ProjectLevel data= new ProjectLevel();
            data.setId(id);
            projectLevelRepo.delete(data);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }
    }
}
