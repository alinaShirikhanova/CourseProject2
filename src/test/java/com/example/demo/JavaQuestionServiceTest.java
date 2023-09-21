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

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    JavaQuestionService javaQuestionService;
    Question question1;
    Question question2;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        question1 = new Question("Вопрос 1", "Ответ 1");
        question2 = new Question("Вопрос 2", "Ответ 2");

        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
    }

    @Test
    void addQuestion() {
        Assertions.assertEquals(List.of(question1, question2), javaQuestionService.getAll());
    }

    @Test
    void addExistingQuestion() {
        Assertions.assertEquals(List.of(question1), javaQuestionService.getAll());
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