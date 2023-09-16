package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JavaQuestionService implements QuestionService {

    private List<Question> questions = new ArrayList<>();


    @Override

    public Question add(String question, String answer) {
        Question box1 = new Question(question, answer);
        questions.add(box1);
        return box1;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
