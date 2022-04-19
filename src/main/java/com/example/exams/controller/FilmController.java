package com.example.exams.controller;

import com.example.exams.domain.Film;
import com.example.exams.service.BaseService;
import com.example.exams.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController extends BaseController<Film> {

    private final FilmService filmService;

    @Override
    protected BaseService<Film, Long> getBaseService() {
        return filmService;
    }
}
