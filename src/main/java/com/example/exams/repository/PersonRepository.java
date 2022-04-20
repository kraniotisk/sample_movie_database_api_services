package com.example.exams.repository;

import com.example.exams.domain.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
  
  @Query("SELECT p FROM Person p WHERE p.name like %:name%")
  List<Person> findByNameStartsWith(String name);
}
