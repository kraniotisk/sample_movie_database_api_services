package com.example.exams.repository;

import com.example.exams.domain.Film;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
  @Query("SELECT f FROM Film f WHERE f.title like %:title%")
  List<Film> findAllByTitleStartsWith(String title);
}
