package com.question.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.Dto.QuestionDto;
import com.question.Model.QuestionWrapper;
import com.question.Model.Questions;
import com.question.Model.Response;
import com.question.Repository.QuestionRepo;
import com.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionRepo questionRepo;

	@Override
	public QuestionDto addQuestion(QuestionDto questionDto) {
		Questions q = new Questions();
		q.setQuestionTitle(questionDto.getQuestionTitle());
		q.setOption1(questionDto.getOption1());
		q.setOption2(questionDto.getOption2());
		q.setOption3(questionDto.getOption3());
		q.setOption4(questionDto.getOption4());
		q.setRightAnswer(questionDto.getRightAnswer());
		q.setDifficultLevel(questionDto.getDifficultLevel());
		q.setCategory(questionDto.getCategory());

		Questions qu = questionRepo.save(q);
		questionDto.setId(qu.getId());
		questionDto.setQuestionTitle(qu.getQuestionTitle());
		questionDto.setOption1(qu.getOption1());
		questionDto.setOption2(qu.getOption2());
		questionDto.setOption3(qu.getOption3());
		questionDto.setOption4(qu.getOption4());
		questionDto.setRightAnswer(qu.getRightAnswer());
		questionDto.setDifficultLevel(qu.getDifficultLevel());
		questionDto.setCategory(qu.getCategory());
		return questionDto;
	}

	@Override
	public List<QuestionDto> getAllQuestions() {
		List<Questions> q = questionRepo.findAll();
		List<QuestionDto> dto = new ArrayList<>();
		for (Questions q1 : q) {
			QuestionDto dto1 = new QuestionDto();
			dto1.setId(q1.getId());
			dto1.setQuestionTitle(q1.getQuestionTitle());
			dto1.setOption1(q1.getOption1());
			dto1.setOption2(q1.getOption2());
			dto1.setOption3(q1.getOption3());
			dto1.setOption4(q1.getOption4());
			dto1.setRightAnswer(q1.getRightAnswer());
			dto1.setDifficultLevel(q1.getDifficultLevel());
			dto1.setCategory(q1.getCategory());
			dto.add(dto1);
		}
		return dto;
	}

	@Override
	public List<QuestionDto> getQuestionByCategory(String category) {
		List<Questions> q = questionRepo.findByCategory(category);
		List<QuestionDto> dto = new ArrayList<>();
		for (Questions qu : q) {
			QuestionDto dto1 = new QuestionDto();
			dto1.setId(qu.getId());
			dto1.setQuestionTitle(qu.getQuestionTitle());
			dto1.setOption1(qu.getOption1());
			dto1.setOption2(qu.getOption2());
			dto1.setOption3(qu.getOption3());
			dto1.setOption4(qu.getOption4());
			dto1.setRightAnswer(qu.getRightAnswer());
			dto1.setDifficultLevel(qu.getDifficultLevel());
			dto1.setCategory(qu.getCategory());
			dto.add(dto1);
		}
		return dto;
	}

//	@Override
//	public ResponseEntity<List<QuestionDto>> getQuestionForQuiz(String categoryName, long numq,
//	        QuestionDto questionDto) {
//	    List<QuestionDto> questions = questionRepo.findRandomQuestionsByCategory(categoryName, numq);
//
//	    return new ResponseEntity<>(questions, HttpStatus.OK);
//	}
	@Override
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, long numq) {
		 List<Integer> questions = questionRepo.findRandomQuestionsByCategory(categoryName, numq);
	        return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Long> questionId) {
     List<QuestionWrapper> wrapper=new ArrayList<>();
     List<Questions> questions=new ArrayList<>();
     for(Long id:questionId) {
    	 questions.add(questionRepo.findById(id).get());
     }
     for(Questions q:questions) {
    	 QuestionWrapper wrappers=new QuestionWrapper();
    	 wrappers.setId(q.getId());
    	 wrappers.setQuestionTitle(q.getQuestionTitle());
    	 wrappers.setOption1(q.getOption1());
    	 wrappers.setOption2(q.getOption2());
    	 wrappers.setOption3(q.getOption3());
    	 wrappers.setOption4(q.getOption4());
    	 wrapper.add(wrappers);
    	 
     }
		return new ResponseEntity<>(wrapper,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> getScore(List<Response> response) {
	      int right=0;
	      for(Response r:response) {
	    	  Questions q=questionRepo.findById(r.getId()).get();
	    	  if(r.getResponse().equals(q.getRightAnswer())) {
	    		  right++;
	    	  }
	      }
			return new ResponseEntity<>(right,HttpStatus.OK);
		}


}
