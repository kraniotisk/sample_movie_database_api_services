package com.example.exams.service;

import com.example.exams.domain.Film;
import com.example.exams.repository.FilmRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return filmRepository;
    }

    @Override
    public List<Film> findAll(String search) {
        return filmRepository.findAllByTitleStartsWith(search);
    }
}
