package com.example.demo.Service;

import com.example.demo.Entity.Question;
import com.example.demo.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getQuestion (String usage)
    {
        return questionRepository.findByUsage (usage);
    }

    public List<Question> getAllQues(){return (List<Question>) questionRepository.findAll ();}
}
