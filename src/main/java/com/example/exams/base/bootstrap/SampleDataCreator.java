package com.example.exams.base.bootstrap;

import com.example.exams.base.BaseComponent;
import com.example.exams.domain.Film;
import com.example.exams.domain.Person;
import com.example.exams.domain.PersonRole;
import com.example.exams.domain.Role;
import com.example.exams.service.FilmService;
import com.example.exams.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SampleDataCreator extends BaseComponent implements CommandLineRunner {

    private final FilmService filmService;

    private final PersonService personService;

    @Override
    public void run(String... args) {
        if (isDBEmpty()) {
            createSampleData();
        }
     }

    private boolean isDBEmpty() {
        return filmService.findAll().isEmpty()?true:false;
    }

    private void createSampleData() {

        List<Film> films = new ArrayList<>();

        Film dummyFilm1 = Film.builder().id(Long.valueOf(1)).title("Juno").genre("Comedy").plotSummary("dummy plot summary 1").rating(BigDecimal.valueOf(7)).build();
        films.add(dummyFilm1);
        Film dummyFilm2 = Film.builder().id(Long.valueOf(2)).title("Interstellar").genre("Sci-fi").plotSummary("dummy plot summary 2").rating(BigDecimal.valueOf(8)).build();
        films.add(dummyFilm2);
        Film dummyFilm3 = Film.builder().id(Long.valueOf(3)).title("Dallas Buyers Club").genre("Drama").plotSummary("dummy plot summary 3").rating(BigDecimal.valueOf(9)).build();
        films.add(dummyFilm3);

        filmService.createAll(films);
        logger.info("Films created: {}.", films);


        List<Person> people = new ArrayList<>();

        List<PersonRole> personRoleList = new ArrayList<>();
        PersonRole dummyPersonRole1 = PersonRole.builder().role(Role.ACTOR).program(dummyFilm2).build();
        personRoleList.add(dummyPersonRole1);
        PersonRole dummyPersonRole2 = PersonRole.builder().role(Role.ACTOR).program(dummyFilm3).build();
        personRoleList.add(dummyPersonRole2);
        Person dummyPerson1 = Person.builder().id(Long.valueOf(1)).name("Matthew McConaughey").personRoles(personRoleList).age(52).build();
        dummyPersonRole1.setPerson(dummyPerson1);
        dummyPersonRole2.setPerson(dummyPerson1);
        people.add(dummyPerson1);

        personRoleList = new ArrayList<>();
        PersonRole dummyPersonRole3 = PersonRole.builder().role(Role.ACTOR).program(dummyFilm1).build();
        personRoleList.add(dummyPersonRole3);
        PersonRole dummyPersonRole4 = PersonRole.builder().role(Role.ACTOR).program(dummyFilm3).build();
        personRoleList.add(dummyPersonRole4);
        Person dummyPerson2 = Person.builder().id(Long.valueOf(2)).name("Jennifer Garner").personRoles(personRoleList).age(49).build();
        people.add(dummyPerson2);

        personService.createAll(people);
        logger.info("People created: {}.", films);
    }
}
