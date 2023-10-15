package com.example.demo.api;


import com.example.demo.BadRequestException;
import com.example.demo.Question;
import com.example.demo.service.JavaQuestionService;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController

public class JavaQuestionController {
    private final QuestionService javaQuestionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    @GetMapping(path = "/exam/java")
    public Collection<Question> getQuestions(){
        return javaQuestionService.getAll();
    }

    @GetMapping(path = "/exam/java/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer)   throws BadRequestException {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping(path = "/exam/java/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return javaQuestionService.remove(new Question(question, answer));
    }

}
