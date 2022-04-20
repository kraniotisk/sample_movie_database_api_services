package com.example.exams.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "PROGRAM")
@SequenceGenerator(name = "idGenerator", sequenceName = "PROGRAM_SEQ", initialValue = 1, allocationSize = 1)
public abstract class Program extends BaseModel {

    @NotNull
    @Column(length = 200, nullable = false)
    @Size(max = 200)
    private String title;

    @Column(precision = 10, scale = 1)
    private BigDecimal rating;

    @NotNull
    @Column(length = 100, nullable = false)
    @Size(max = 100)
    private String genre;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"program"})
    private List<PersonRole> personRoles;
}
