package com.poly.interractive3dvirtualtours.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    RegisterRepository registerRepository;

    public List<Register> getAll()
    {
        List<Register> register = new ArrayList<>();
        registerRepository.findAllRegistered().forEach(register1 -> register.add(register1));
        return register;
    }

    public Register getById(int id)
    {
        return registerRepository.findRegisteredById(id);
    }

    public void saveOrUpdate(Register register)
    {
        registerRepository.saveAndFlush(register);
    }

    public void delete(int id)
    {
        registerRepository.deleteById(id);
    }

    public void update(Register register, int id)
    {
        registerRepository.saveAndFlush(register);
    }


}