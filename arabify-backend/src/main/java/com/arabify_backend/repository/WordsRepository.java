package com.arabify_backend.repository;

import com.arabify_backend.model.Words;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordsRepository extends JpaRepository<Words,Long> {

    List<Words> findByCategory(String category);
    List<Words> findByPartOfSpeech(String partOfSpeech);
}
