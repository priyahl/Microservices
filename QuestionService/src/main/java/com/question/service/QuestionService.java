package com.question.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.question.Dto.QuestionDto;
import com.question.Model.QuestionWrapper;
import com.question.Model.Response;

public interface QuestionService {
   public QuestionDto addQuestion(QuestionDto questionDto);
   public List<QuestionDto> getAllQuestions(); 
   public List<QuestionDto> getQuestionByCategory(String category);
public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Long> questionId);
public ResponseEntity<Integer> getScore(List<Response> response);
ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, long numq);
}
