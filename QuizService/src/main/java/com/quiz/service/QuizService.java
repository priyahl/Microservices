package com.quiz.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.quiz.Dto.QuizDto;
import com.quiz.Model.QuestionWrapper;
import com.quiz.Model.Response;

public interface QuizService {
//   public ResponseEntity<QuizDto> createQuiz(String category,long numq, QuizDto quizDto);
 
public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(long id);

public ResponseEntity<Integer> calResult(long id, List<Response> response);

public ResponseEntity<String> createQuiz(String categoryName, long numq, String title);
}
