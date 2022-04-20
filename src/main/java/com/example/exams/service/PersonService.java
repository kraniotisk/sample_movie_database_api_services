package com.example.exams.service;

import com.example.exams.domain.Person;
import com.example.exams.domain.Program;
import com.example.exams.domain.Role;

public interface PersonService extends BaseService<Person, Long>{

  void assign(Person person, Program program, Role role);
}
