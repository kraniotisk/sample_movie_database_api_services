package com.example.exams.controller;

import com.example.exams.domain.Person;
import com.example.exams.domain.Show;
import com.example.exams.service.BaseService;
import com.example.exams.service.PersonService;
import com.example.exams.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shows")
public class ShowController extends BaseController<Show> {

    private final ShowService showService;

    @Override
    protected BaseService<Show, Long> getBaseService() {
        return showService;
    }
}
