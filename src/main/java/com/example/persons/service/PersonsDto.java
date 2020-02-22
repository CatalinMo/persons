package com.example.persons.service;

import com.example.persons.dao.AddressEntity;
import lombok.Data;

@Data
public class PersonsDto {

    private String firstName;
    private String lastName;
    private Integer age;
    private AddressDto address;

    public PersonsDto toDto()
    {
        PersonsDto dto = new PersonsDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setAddress(address);
        return dto;
    }

    public PersonsDto update(PersonsDto dto)
    {
        this.firstName=dto.getFirstName();
        this.lastName=dto.getLastName();
        this.address=dto.getAddress();
        return this;
    }
}
