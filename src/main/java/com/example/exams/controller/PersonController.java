package com.example.exams.controller;

import com.example.exams.domain.Person;
import com.example.exams.service.BaseService;
import com.example.exams.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController extends BaseController<Person> {

    private final PersonService personService;

    @Override
    protected BaseService<Person, Long> getBaseService() {
        return personService;
    }
}
