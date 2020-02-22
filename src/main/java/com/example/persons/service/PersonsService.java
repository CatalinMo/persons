package com.example.persons.service;

import com.example.persons.dao.AddressRepository;
import com.example.persons.dao.PersonRepository;
import com.example.persons.dao.PersonsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsService {

    private PersonRepository personRepository;
    private AddressRepository addressRepository;

    public PersonsService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public List<PersonsEntity> getAll()
    {
        return personRepository.findAll();
    }

    public void addPersons(PersonsDto personsDto)
{
    PersonsEntity personsEntity = new PersonsEntity();
    personsEntity = personsEntity.update(personsDto);
    personRepository.save(personsEntity);
    addressRepository.save(personsEntity.getAddress());
}
}
