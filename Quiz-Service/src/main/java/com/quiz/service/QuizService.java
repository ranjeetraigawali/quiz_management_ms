package com.quiz.service;

import com.quiz.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuizService {
    String createQuiz(Quiz quiz);

    List<Quiz> getAll();

    Optional<Quiz> getQuiz(Long id);
}
