package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Quiz;

@Repository                                 // not entity but Quiz class
public interface QuizDAO extends JpaRepository<Quiz, Integer>{

}
