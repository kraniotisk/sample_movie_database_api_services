package com.example.exams.domain;

import com.example.exams.domain.Program;
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

    @Column(nullable = false)
    private String channel;

    @Column(nullable = false)
    private Integer episodes;

}
