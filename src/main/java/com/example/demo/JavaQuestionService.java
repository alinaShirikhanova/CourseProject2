package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;


@Service
public class JavaQuestionService implements QuestionService {

    private final ArrayList<Question> questions = new ArrayList<>();


    @Override
    public Question add(String question, String answer) {
        for (Question questionElem : questions) {
            if (questionElem.getQuestion().equals(question))
                return null;
        }
        Question questionObject = new Question(question, answer);
        questions.add(questionObject);
        return questionObject;
    }

    @Override
    public Question add(Question question) {
        for (Question questionElem : questions) {
            if (questionElem.getQuestion().equals(question.getQuestion()))
                return null;
        }
        questions.add(question);
        return question;
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
        return null;
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
