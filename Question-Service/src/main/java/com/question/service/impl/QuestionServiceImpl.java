package com.question.service.impl;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Override
    public String createQuestion(Question question) {
        try {
            questionRepository.save(question);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Question added to the quiz successfully.";
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> getQuestion(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getQuestionsForQuiz(Long id) {
        return questionRepository.findByQuizId(id);
    }
}
