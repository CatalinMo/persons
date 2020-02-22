package com.example.persons.service;

import com.example.persons.dao.AddressEntity;
import com.example.persons.dao.PersonsEntity;
import lombok.Data;

@Data
public class AddressDto {

    private String city;
    private String street;
    private PersonsEntity persons;

    public  AddressDto toDto(AddressEntity address)
    {
        AddressDto dto = new AddressDto();
        dto.setStreet(address.getStreet());
        return dto;
    }

    public AddressEntity update(AddressDto dto)
    {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(dto.getCity());
        addressEntity.setStreet(dto.getStreet());
        return addressEntity;
    }
}
