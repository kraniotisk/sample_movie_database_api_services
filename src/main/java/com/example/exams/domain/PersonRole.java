package com.example.exams.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "PERSON_ROLE", indexes = {@Index(columnList = "person_id"), @Index(columnList = "program_id")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSON_ROLE_SEQ", initialValue = 1, allocationSize = 1)
public class PersonRole extends BaseModel{

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonIgnoreProperties({"personRoles"})
    private Person person;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    @JsonIgnoreProperties({"personRoles"})
    private Program program;
}
