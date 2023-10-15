package com.example.demo;

import com.example.demo.service.ExaminerServiceImpl;
import com.example.demo.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;
    Question question1;
    Question question2;
    Question question3;
    Question question4;

    @BeforeEach
    public void setUp() {
        question1 = new Question("Question1", "Answer1");
        question2 = new Question("Question2", "Answer2");
        question3 = new Question("Question3", "Answer3");
        question4 = new Question("Question4", "Answer4");
        Mockito.when(questionService.getAll()).thenReturn(List.of(question1, question2, question3, question4));
    }

    @Test
    public void getQuestionsTest() {
        Mockito.when(questionService.getRandomQuestion()).thenReturn(question1, question1, question2, question2, question3, question4);
        assertEquals(new HashSet<>(List.of(question1, question2, question3, new Question("Question4", "Answer4"))), new HashSet<>(examinerService.getQuestions(4)));
    }


    @Test
    public void getQuestionsTest2() {
        assertThrows(BadRequestException.class, () -> examinerService.getQuestions(5));
    }
}