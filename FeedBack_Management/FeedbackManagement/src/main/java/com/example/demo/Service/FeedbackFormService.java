package com.example.demo.Service;

import com.example.demo.Entity.FeedbackFormMapper;
import com.example.demo.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackFormService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public FeedbackFormMapper getAllFeedback(int qid)
    {
        return  feedbackRepository.findByQuesionid (qid);
    }
}
