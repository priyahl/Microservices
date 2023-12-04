package com.quiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.Model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>{

}
