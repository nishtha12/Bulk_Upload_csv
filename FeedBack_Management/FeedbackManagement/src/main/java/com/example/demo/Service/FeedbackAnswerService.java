package com.example.demo.Service;

import com.example.demo.Entity.FeedbackAnswer;
import com.example.demo.Repository.FeedbackAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackAnswerService {

    @Autowired
    FeedbackAnswerRepository feedbackAnswerRepository;


    public boolean submitform(FeedbackAnswer feedbackAnswer)
    {
        FeedbackAnswer answer = feedbackAnswerRepository.save(feedbackAnswer);
        System.out.println ("Answer submited "+answer);
        if (answer == null) {
            return false;
        }else
            return true;
    }    }


