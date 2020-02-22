package com.example.persons.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonsEntity, Long> {
}
