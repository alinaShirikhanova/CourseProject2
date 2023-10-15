package com.example.demo;

import com.example.demo.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
        assertEquals(List.of(question1, question2), javaQuestionService.getAll());
    }

    @Test
    void addQuestion2() {
        assertThrows(BadRequestException.class, () -> javaQuestionService.add(new Question("Question 1", "Answer 1")));
    }

//    @Test
//    void addExistingQuestion() {
//        javaQuestionService.add(question1);
//        javaQuestionService.add(question2);
//        assertEquals(List.of(question1, question2), javaQuestionService.getAll());
//    }


    @Test
    void remove() {
        javaQuestionService.remove(question1);
        assertEquals(List.of(question2), javaQuestionService.getAll());
    }

    @Test
    void remove2() {
        assertThrows(BadRequestException.class, () -> javaQuestionService.remove(new Question("волырваы", "jsfs")));
    }

    @Test
    void getAll() {
        Assertions.assertEquals(List.of(question1, question2), javaQuestionService.getAll());
    }
}