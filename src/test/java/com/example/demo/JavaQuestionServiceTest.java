package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    JavaQuestionService javaQuestionService = new JavaQuestionService();
    Question question1;
    Question question2;

    @BeforeEach
    void setUp() throws BadRequestException {
        question1 = new Question("Question 1", "Answer 1");
        question2 = new Question("Question 2", "Answer 2");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
    }

    @Test
    void addQuestion() {
        Assertions.assertEquals(List.of(question1, question2), javaQuestionService.getAll());
    }

    @Test
    void addExistingQuestion() {
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        Assertions.assertEquals(List.of(question1, question2), javaQuestionService.getAll());
    }


    @Test
    void remove() {
        javaQuestionService.remove(question1);
        Assertions.assertEquals(List.of(question2), javaQuestionService.getAll());
    }

    @Test
    void getAll() {
        Assertions.assertEquals(List.of(question1, question2), javaQuestionService.getAll());
    }
}