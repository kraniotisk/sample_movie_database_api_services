package com.example.exams.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
//@Table(name = "FILM")
//@SequenceGenerator(name = "idGenerator", sequenceName = "FILM_SEQ", initialValue = 1, allocationSize = 1)
public class Film extends Program {

    @NotNull
    @Column(length = 10000, nullable = false)
    private String plotSummary;

}
