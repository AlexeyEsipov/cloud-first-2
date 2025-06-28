package ru.job4j.first.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    @Value("${app.word:none}")
    private String word;

    public String getWord() {
        return word;
    }
}
