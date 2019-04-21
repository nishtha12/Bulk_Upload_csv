package com.example.demo.Repository;

import com.example.demo.Entity.FeedbackForm;
import com.example.demo.Entity.FeedbackFormMapper;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<FeedbackFormMapper,Integer> {

    FeedbackFormMapper findByQuesionid(int id);
}
