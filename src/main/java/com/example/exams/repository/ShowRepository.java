package com.example.exams.repository;

import com.example.exams.domain.Show;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
  @Query("SELECT s FROM Show s WHERE s.title like %:title%")
  List<Show> findAllByTitleStartsWith(String title);
}
