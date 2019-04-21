package com.example.demo.Repository;

import com.example.demo.Entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question,Integer> {

    List<Question> findByUsage(String usage);
}
