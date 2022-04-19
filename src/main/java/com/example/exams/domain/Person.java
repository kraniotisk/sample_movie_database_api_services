package com.example.moviedatabase.domain;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSON_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {

    @NotNull
    @Column(length = 200, nullable = false)
    private String name;

    private Integer age;

    @OneToMany(mappedBy = "person")
    private List<PersonRole> personRoles;

}
