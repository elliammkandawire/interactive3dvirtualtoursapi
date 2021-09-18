package com.poly.interractive3dvirtualtours.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    RegisterRepository registerRepository;

    //read all those registered
    public List<Register> getAll()
    {
        List<Register> register = new ArrayList<>();
        registerRepository.findAllRegistered().forEach(register1 -> register.add(register1));
        return register;
    }

    //fitler registred by id
    public Register getById(int id)
    {
        return registerRepository.findRegisteredById(id);
    }

    public void saveOrUpdate(Register register)
    {
        registerRepository.saveAndFlush(register);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        registerRepository.deleteById(id);
    }
    //updating a record
    public void update(Register register, int id)
    {
        registerRepository.saveAndFlush(register);
    }


}