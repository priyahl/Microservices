package com.quiz.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.Feign.QuizInterface;
import com.quiz.Model.QuestionWrapper;
import com.quiz.Model.Quiz;
import com.quiz.Model.Response;
import com.quiz.Repository.QuizRepo;
import com.quiz.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService{
	@Autowired
	QuizRepo quizRepo;

	@Autowired
	QuizInterface quizInterface;

	@Override
	public ResponseEntity<String> createQuiz(String categoryName, long numq, String title) {
		List<Integer> questions = quizInterface.getQuestionsForQuiz(categoryName, numq).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionId(questions);
		quizRepo.save(quiz);

		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(long id) {
		Quiz quiz=quizRepo.findById(id).get();
		List<Integer> questionId=quiz.getQuestionId();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionFromId(questionId);
		return questions;
	}

	@Override
	public ResponseEntity<Integer> calResult(long id, List<Response> response) {
        ResponseEntity<Integer> score = quizInterface.getScore(response);
        return score;
	}

}
