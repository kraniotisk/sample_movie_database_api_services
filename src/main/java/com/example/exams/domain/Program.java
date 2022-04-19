package com.example.exams.domain;

import com.sun.istack.NotNull;
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
    private String title;

    @Column(precision = 10, scale = 1)
    private BigDecimal rating;

    @Column(length = 100, nullable = false)
    private String genre;

}
