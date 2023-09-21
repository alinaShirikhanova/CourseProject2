package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws BadRequestException;
}
