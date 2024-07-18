package com.arabify_backend.controller;

import com.arabify_backend.model.Words;
import com.arabify_backend.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/words")
public class WordsController {

    @Autowired
    private WordsRepository wordsRepository;

    @GetMapping("/getAllWords")
    public List<Words> getAllWords() {
        return wordsRepository.findAll();
    }

    @GetMapping("/getSingleWord/{id}")
    public ResponseEntity<Words> getWordById(@PathVariable Long id) {
        Optional<Words> word = wordsRepository.findById(id);
        return word.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createWord")
    public Words createWord(@RequestBody Words word) {
        return wordsRepository.save(word);
    }




}