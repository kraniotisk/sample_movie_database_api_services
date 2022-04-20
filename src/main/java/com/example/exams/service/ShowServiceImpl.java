package com.example.exams.service;

import com.example.exams.domain.Show;
import com.example.exams.repository.ShowRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowServiceImpl extends BaseServiceImpl<Show> implements ShowService {

    private final ShowRepository showRepository;

    @Override
    public JpaRepository<Show, Long> getRepository() {
        return showRepository;
    }


    @Override
    public List<Show> findAll(String search) {
        return showRepository.findAllByTitleStartsWith(search);
    }
}
