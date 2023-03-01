package com.example.onetoonemapping.controller;

import com.example.onetoonemapping.model.PersonRequest;
import com.example.onetoonemapping.model.PersonResponse;
import com.example.onetoonemapping.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/persons")
    public ResponseEntity<PersonRequest> createPerson(@RequestBody PersonRequest personRequest)
    {
        PersonRequest personRequest1=personService.createPerson(personRequest);
        return new ResponseEntity<>(personRequest1, HttpStatus.CREATED);
    }

    @GetMapping("/persons/{personId}")
    public ResponseEntity<PersonRequest> getPersonById(@PathVariable Long personId)
    {
        PersonRequest personRequest=personService.getPersonById(personId);
        return new ResponseEntity<>(personRequest,HttpStatus.OK);
    }

    @PutMapping("/persons/{personId}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long personId, @RequestBody PersonRequest personRequest)
    {
        PersonResponse personResponse=personService.updatePerson(personId,personRequest);
        return new ResponseEntity<>( personResponse,HttpStatus.OK);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonRequest>> getAllPerson()
    {
        List<PersonRequest> personRequestList=personService.getAllPerson();
        return new ResponseEntity<>(personRequestList,HttpStatus.OK);
    }


}
