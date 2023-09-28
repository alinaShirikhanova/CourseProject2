package com.example.demo;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer) throws BadRequestException;

    Question add(Question question) throws BadRequestException;

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
