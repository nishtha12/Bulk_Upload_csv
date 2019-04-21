package com.example.demo.Repository;

import com.example.demo.Entity.FeedbackAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackAnswerRepository extends CrudRepository<FeedbackAnswer,Integer> {

}

