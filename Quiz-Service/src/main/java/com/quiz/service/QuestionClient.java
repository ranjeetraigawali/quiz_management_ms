package com.quiz.service;


import com.quiz.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * For normal application -
 * @FeignClient(url = "http://localhost:8082", value = "Question-Client") **/

/**
 * When we have service registry / discovery server enabled.
 */

@FeignClient(name = "Question-Service")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
}
