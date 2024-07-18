package com.arabify_backend.service;


import com.arabify_backend.model.Words;
import com.arabify_backend.repository.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsService {

    @Autowired
    private WordsRepository wordsRepository;

    public List<Words> getAllWords() {
        return wordsRepository.findAll();
    }

    public Words getWordById(Long id) {
        return wordsRepository.findById(id).orElse(null);
    }

    public Words saveWord(Words word) {
        return wordsRepository.save(word);
    }

    public void deleteWord(Long id) {
        wordsRepository.deleteById(id);
    }

    public List<Words> getWordsByCategory(String category) {
        return wordsRepository.findByCategory(category);
    }

    public List<Words> getWordsByPartOfSpeech(String partOfSpeech) {
        return wordsRepository.findByPartOfSpeech(partOfSpeech);
    }

}
