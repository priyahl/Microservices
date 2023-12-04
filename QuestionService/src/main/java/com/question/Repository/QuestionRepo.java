package com.question.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.question.Dto.QuestionDto;
import com.question.Model.Questions;

public interface QuestionRepo extends JpaRepository<Questions, Long>{

	List<Questions> findByCategory(String category);
	
   @Query(value="SELECT q.id from questions q Where q.category=:category ORDER BY RAND() LIMIT :numq",nativeQuery=true)
	List<Integer> findRandomQuestionsByCategory(String category, long numq);

}
