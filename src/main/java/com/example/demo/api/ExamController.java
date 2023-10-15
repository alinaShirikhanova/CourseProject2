package com.example.demo.api;

import com.example.demo.BadRequestException;
import com.example.demo.service.ExaminerService;
import com.example.demo.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;


    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    Collection<Question> getQuestions(@PathVariable int amount) throws BadRequestException {
        return examinerService.getQuestions(amount);
    }
}
