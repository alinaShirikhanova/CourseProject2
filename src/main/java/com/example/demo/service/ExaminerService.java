package com.example.demo.service;

import com.example.demo.BadRequestException;
import com.example.demo.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws BadRequestException;
}
