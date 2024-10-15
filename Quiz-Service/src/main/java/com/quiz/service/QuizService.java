package com.quiz.service;

import com.quiz.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    String createQuiz(Quiz quiz);

    List<Quiz> getAll();

    Quiz getQuiz(Long id);
}
