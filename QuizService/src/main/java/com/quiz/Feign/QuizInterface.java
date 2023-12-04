package com.quiz.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.Dto.QuestionDto;
import com.quiz.Model.QuestionWrapper;
import com.quiz.Model.Response;


@FeignClient("QUESTIONSERVICE")
public interface QuizInterface {
	  @GetMapping("/generate")
	    public ResponseEntity<List<Integer>> getQuestionsForQuiz
	            (@RequestParam String categoryName, @RequestParam long numq );
	  
	 @PostMapping("/getQuestions")
		public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionId);
	 
	  @PostMapping("/getScore")
	    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response);


}
