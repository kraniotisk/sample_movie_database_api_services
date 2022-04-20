package com.example.exams.service;

import com.example.exams.domain.Person;
import com.example.exams.domain.PersonRole;
import com.example.exams.domain.Program;
import com.example.exams.domain.Role;
import com.example.exams.repository.PersonRepository;
import com.example.exams.repository.PersonRoleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {

    private final PersonRepository personRepository;
    private final PersonRoleRepository personRoleRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void assign(Person person, Program program, Role role) {
        PersonRole personRole = PersonRole.builder().person(person).program(program).role(role).build();
        personRoleRepository.save(personRole);
        logger.info("Saved person role {}.", personRole);
    }

    @Override
    public List<Person> findAll(String search) {
        return personRepository.findByNameStartsWith(search);
    }
}
