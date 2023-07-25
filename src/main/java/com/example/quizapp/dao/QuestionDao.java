package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    //To get data as per our requirement we need to use native query
    @Query(value = "SELECT * FROM question q WHERE q.category= ?1 ORDER BY RANDOM() LIMIT= ?2", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
