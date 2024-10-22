package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.entity;


@Repository                             // table type    // primary key
public interface QuesDAO extends JpaRepository<entity , Integer> {

    List<entity> findByTopicName(String topicName);

        @Query(value = "SELECT * FROM entity q WHERE q.topic_name = :topicName  ORDER BY RAND()", nativeQuery = true)
        List<entity> findRandomQuestionByCategory(Pageable pageable, @Param("topicName") String topicName);
    
}
