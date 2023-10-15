package com.example.demo.service;

import com.example.demo.BadRequestException;
import com.example.demo.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService{
    private ArrayList<Question> questions = new ArrayList<>();


    @Override
    public Question add(String question, String answer) {
//        if (questions == null)
//            questions = new ArrayList<>();
//        for (Question questionElem : questions) {
//            if (questionElem.getQuestion().equals(question))
//               throw new BadRequestException("Такой вопрос уже существует");
//        }
        if (questions.contains(new Question(question, answer)))
            throw new BadRequestException("Такой вопрос уже существует");
        Question questionObject = new Question(question, answer);
        questions.add(questionObject);
        return questionObject;
    }


    @Override
    public Question add(Question question) {
        return add(question.getQuestion(), question.getAnswer());
    }


    @Override
    public Question remove(Question question) {
        Question questionToRemove;
        for (Question elem : questions) {
            if (elem.getQuestion().equals(question.getQuestion()) && elem.getAnswer().equals(question.getAnswer())) {
                questionToRemove = elem;
                questions.remove(elem);
                return questionToRemove;
            }
        }
        throw new BadRequestException("Такого вопроса нет");
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
