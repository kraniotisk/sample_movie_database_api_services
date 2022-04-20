package com.example.exams.base.bootstrap;

import com.example.exams.base.BaseComponent;
import com.example.exams.domain.Film;
import com.example.exams.domain.Person;
import com.example.exams.domain.Role;
import com.example.exams.domain.Show;
import com.example.exams.service.FilmService;
import com.example.exams.service.PersonService;
import com.example.exams.service.ShowService;
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
    
    private final ShowService showService;

    private final PersonService personService;

    @Override
    public void run(String... args) {
        if (isDBEmpty()) {
            createSampleData();
        }
     }

    private boolean isDBEmpty() {
        return filmService.findAll().isEmpty();
    }

    private void createSampleData() {

        List<Film> films = new ArrayList<>();

        Film dummyFilm1 = Film.builder().title("Juno").genre("Comedy").plotSummary("dummy plot summary 1").rating(BigDecimal.valueOf(7)).build();
        films.add(dummyFilm1);
        Film dummyFilm2 = Film.builder().title("Interstellar").genre("Sci-fi").plotSummary("dummy plot summary 2").rating(BigDecimal.valueOf(8)).build();
        films.add(dummyFilm2);
        Film dummyFilm3 = Film.builder().title("Dallas Buyers Club").genre("Drama").plotSummary("dummy plot summary 3").rating(BigDecimal.valueOf(9)).build();
        films.add(dummyFilm3);

        filmService.createAll(films);
        logger.info("Films created: {}.", films);

        List<Show> shows = new ArrayList<>();
        
        Show dummyShow1 = Show.builder().title("Seinfeld").genre("Comedy").channel("NBC").episodes(180).rating(BigDecimal.valueOf(8)).build();
        shows.add(dummyShow1);
        Show dummyShow2 = Show.builder().title("Breaking Bad").genre("Drama").channel("AMC").episodes(62).rating(BigDecimal.valueOf(7)).build();
        shows.add(dummyShow2);
        
        showService.createAll(shows);
        logger.info("Shows created: {}.", shows);

        List<Person> people = new ArrayList<>();
        
        Person dummyPerson1 = Person.builder().name("Matthew McConaughey").age(52).build();
        people.add(dummyPerson1);
        Person dummyPerson2 = Person.builder().name("Jennifer Garner").age(49).build();
        people.add(dummyPerson2);
        Person dummyPerson3 = Person.builder().name("Jerry Seinfeld").age(67).build();
        people.add(dummyPerson3);
        Person dummyPerson4 = Person.builder().name("Vince Gilligan").age(55).build();
        people.add(dummyPerson4);
        
        personService.createAll(people);
        logger.info("People created: {}.", films);
        
        personService.assign(dummyPerson1, dummyFilm2, Role.ACTOR);
        personService.assign(dummyPerson1, dummyFilm3, Role.ACTOR);
        personService.assign(dummyPerson2, dummyFilm1, Role.ACTOR);
        personService.assign(dummyPerson2, dummyFilm3, Role.ACTOR);
        personService.assign(dummyPerson3, dummyShow1, Role.PRODUCER);
        personService.assign(dummyPerson4, dummyShow2, Role.DIRECTOR);
    }
}
