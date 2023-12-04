package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.Dto.QuizDto;
import com.quiz.Dto.QuizDto1;
import com.quiz.Model.QuestionWrapper;
import com.quiz.Model.Response;
import com.quiz.service.QuizService;

@RestController
public class QuizController {
	@Autowired
	QuizService quizService;
	
//    @PostMapping("/create/{category}/{numq}")
//	public ResponseEntity<String> createQuiz(@RequestBody QuizDto1 quizDto1)
//	{
//		return quizService.createQuiz(quizDto1.getCategoryName(), quizDto1.getNumq(), quizDto1.getTitle());
//	}
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto1 quizDto1){
        return quizService.createQuiz(quizDto1.getCategoryName(), quizDto1.getNumq(), quizDto1.getTitle());
    }
    
    @GetMapping("/getq/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable long id){
    	return quizService.getQuizQuestions(id);
    }
    
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submittQuiz(@PathVariable long id,@RequestBody List<Response> response){
    	return quizService.calResult(id,response);
    }
}
