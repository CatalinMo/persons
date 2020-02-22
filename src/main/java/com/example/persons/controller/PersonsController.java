package com.example.persons.controller;

import com.example.persons.dao.PersonsEntity;
import com.example.persons.service.PersonsDto;
import com.example.persons.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonsController {

    private PersonsService personsService;

    @Autowired
    public PersonsController(PersonsService personsService)
    {
        this.personsService = personsService;
    }

    @GetMapping("/")
    public List<PersonsDto> getAll()
    {
        List<PersonsEntity> personsEntities = personsService.getAll();
        return personsEntities.stream().map(PersonsEntity::toDto).collect(Collectors.toList());
    }

    @PostMapping("/")
    public void addPersons(@RequestBody PersonsDto personsEntity)
    {
        personsService.addPersons(personsEntity);
    }
}
