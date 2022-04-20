package com.example.exams.domain;

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
@Table(name = "SHOW")
public class Show extends Program {

    @NotNull
    @Column(nullable = false)
    private String channel;

    @NotNull
    @Column(nullable = false)
    private Integer episodes;
}
