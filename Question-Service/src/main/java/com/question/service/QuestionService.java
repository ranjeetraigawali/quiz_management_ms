package com.question.service;

import com.question.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionService {
    String createQuestion(Question question);

    List<Question> getAllQuestions();

    Optional<Question> getQuestion(Long id);

    List<Question> getQuestionsForQuiz(Long id);
}
