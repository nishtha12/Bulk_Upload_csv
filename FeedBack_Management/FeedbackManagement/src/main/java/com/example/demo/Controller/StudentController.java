package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Service.FeedbackAnswerService;
import com.example.demo.Service.FeedbackFormService;
import com.example.demo.Service.QuestionService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;
    @Autowired
    FeedbackFormService feedbackFormService;

    @Autowired
    FeedbackAnswerService feedbackAnswerService;

    @RequestMapping(value = "/Student" ,method = RequestMethod.GET)
    public ModelAndView homePage(@ModelAttribute("user")User user, HttpSession session) {
        User user1 = session.getAttribute ("userObject") != null ? (User) session.getAttribute ("userObject") : null;
        if (user1 == null) {
            ModelAndView mv = new ModelAndView ("index");
            mv.addObject ("user", new User ());
            return mv;
        } else {
            ModelAndView m2 = new ModelAndView ("formpage");
            List<Question> question= questionService.getQuestion ("administrator");
            FeedbackFormMapper feedbackForms= feedbackFormService.getAllFeedback(25);


            //   System.out.println (question);
            m2.addObject ("form",question);
            m2.addObject ("feedbackform",feedbackForms);
            return m2;
        }
    }

    @RequestMapping(value = "/submit-form",method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("Answer") FeedbackAnswer feedbackAnswer ,@ModelAttribute("feedbackform") FeedbackFormMapper feedbackFormMapper,@ModelAttribute("form") Question question){
        ModelAndView submitsucess = new ModelAndView ("success");
        FeedbackAnswer fa= new FeedbackAnswer (101,feedbackFormMapper.getFormid (),question.getQuesId (),"good",null);
        boolean check = feedbackAnswerService.submitform (fa);
        if(check==true)
        {
            return submitsucess;
        }
        else
        {
            return new ModelAndView ("index");
        }
        }

}
