package com.quiz.controller;

import com.quiz.entity.Quiz;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public String createQuiz(@RequestBody Quiz quiz){
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/list")
    public List<Quiz> getAll(){
        return quizService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Quiz> getQuiz(@PathVariable Long id){
        return quizService.getQuiz(id);
    }
}
