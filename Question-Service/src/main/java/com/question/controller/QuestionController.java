package com.question.controller;

import com.question.entity.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/create")
    public String createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping("/list")
    public List<Question> getAll(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/get/{id}")
    public Optional<Question> getQuestion(@PathVariable Long id){
        return questionService.getQuestion(id);
    }

    @GetMapping("quiz/{id}")
    public List<Question> getQuestionsForQuiz(@PathVariable Long id) {
        return questionService.getQuestionsForQuiz(id);
    }
}
