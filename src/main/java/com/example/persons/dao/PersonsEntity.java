package com.example.persons.dao;

import com.example.persons.service.AddressDto;
import com.example.persons.service.PersonsDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PersonsEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;

    @OneToOne(mappedBy = "persons", fetch = FetchType.EAGER)
    private AddressEntity address;

    public PersonsDto toDto()
    {
        PersonsDto dto = new PersonsDto();
        AddressDto addressPojo = new AddressDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setAge(age);
        dto.setAddress(addressPojo.toDto(address));
        return dto;
    }

    public PersonsEntity update(PersonsDto pojo)
    {
        PersonsEntity personsEntity = new PersonsEntity();
        personsEntity.setFirstName(pojo.getFirstName());
        personsEntity.setLastName(pojo.getLastName());
        personsEntity.setAge(pojo.getAge());
        AddressEntity addressEntity = pojo.getAddress().update(pojo.getAddress());
        addressEntity.setPersons(personsEntity);
        personsEntity.setAddress(addressEntity);
        return personsEntity;
    }


}
