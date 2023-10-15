package com.example.demo.service;

import com.example.demo.BadRequestException;
import com.example.demo.Question;
import com.example.demo.service.ExaminerService;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    Random random =  new Random();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws BadRequestException {
        if (amount > questionService.getAll().size())
            throw new BadRequestException("BAD_REQUEST");
        ArrayList<Question> randomQuestions = new ArrayList<>();
        while (randomQuestions.size() < amount) {
            Question question = questionService.getRandomQuestion();
            if (!randomQuestions.contains(question))
                randomQuestions.add(question);
        }
        return randomQuestions;
    }
}
