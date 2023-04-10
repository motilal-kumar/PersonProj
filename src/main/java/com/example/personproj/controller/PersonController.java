package com.example.personproj.controller;


import com.example.personproj.entity.Person;
import com.example.personproj.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private IPersonService personService;

    // handler method to handle list of students
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> persons(){
        List<Person> personList = personService.findAllUsers();

        System.out.println("personList: "+personList);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }


}
