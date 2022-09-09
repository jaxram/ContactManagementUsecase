package com.usecase.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.entity.Person;


public interface ContactRepository extends JpaRepository<Person, Long> {

}
