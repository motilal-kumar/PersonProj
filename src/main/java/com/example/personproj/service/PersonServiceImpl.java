package com.example.personproj.service;


import com.example.personproj.entity.Person;
import com.example.personproj.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllUsers() {

        List<Person> personList = personRepository.findAll();

        System.out.println("personList: "+personList);
        return personList;
    }
}
