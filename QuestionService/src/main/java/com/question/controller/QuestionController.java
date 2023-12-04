package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.question.Dto.QuestionDto;
import com.question.Model.QuestionWrapper;
import com.question.Model.Response;
import com.question.service.QuestionService;

@RestController
public class QuestionController {

	@Autowired
	QuestionService questionService;
    @Autowired
	Environment environment;
	
	@GetMapping("/question")
	public List<QuestionDto> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@PostMapping(("/addquestions"))
	public QuestionDto addQuestions(@RequestBody QuestionDto questionDto) {
		return questionService.addQuestion(questionDto);
	}

	@GetMapping("/getByCategory/{category}")
	public List<QuestionDto> getQuestionByCategory(@PathVariable String category) {
		return questionService.getQuestionByCategory(category);
	}
	
	
//	 @GetMapping("/generate/{categoryName}/{numq}")
//		public ResponseEntity<List<QuestionDto>> getQuestionForQuiz(@PathVariable String categoryName, @PathVariable long numq,@RequestBody QuestionDto questionDto)
//		{
//			return questionService.getQuestionForQuiz(categoryName, numq, questionDto);
//		}
	
	  @GetMapping("/generate")
	    public ResponseEntity<List<Integer>> getQuestionsForQuiz
	            (@RequestParam String categoryName, @RequestParam long numq ){
	        return questionService.getQuestionsForQuiz(categoryName, numq);
	    }
	 
	 @PostMapping("/getQuestions")
		public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Long> questionId)
		{
		 System.out.println(environment.getProperty("local.server.port"));
			return questionService.getQuestionFromId(questionId);
		}
	 
	  @PostMapping("/getScore")
	    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response){
	    	return questionService.getScore(response);
	    }
	 
}
