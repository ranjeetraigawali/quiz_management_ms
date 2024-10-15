package com.quiz.service.impl;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;
    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }
    @Override
    public String createQuiz(Quiz quiz) {
        try {
            quizRepository.save(quiz);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Quiz added successfully...";
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizList = quizRepository.findAll();
        List<Quiz> quizWithQuestionsList = quizList.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return quizWithQuestionsList;
    }

    @Override
    public Quiz getQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found..."));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(id));
        return quiz;
    }
}
