package com.example.demo.api;

import com.example.demo.BadRequestException;
import com.example.demo.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService")QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping(path = "/exam/java")
    public Collection<Question> getQuestions(){
        return questionService.getAll();
    }

    @GetMapping(path = "/exam/java/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer)   throws BadRequestException {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/exam/java/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return questionService.remove(new Question(question, answer));
    }

}
