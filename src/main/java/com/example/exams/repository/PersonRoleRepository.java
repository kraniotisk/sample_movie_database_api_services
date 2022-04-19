package com.example.exams.repository;

import com.example.exams.domain.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRoleRepository extends JpaRepository<PersonRole, Long> {
}
