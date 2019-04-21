package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/Dashboard" ,method = RequestMethod.GET)
    public ModelAndView homePage(@ModelAttribute("user")User user, HttpSession session) {
        User user1 = session.getAttribute ("userObject") != null ? (User) session.getAttribute ("userObject") : null;
        if (user1 == null) {
            ModelAndView mv = new ModelAndView ("index");
            mv.addObject ("user", new User ());
            return mv;
        } else
            return new ModelAndView ("Dashboard");

    }
    @RequestMapping(value = "/UserDetails" ,method = RequestMethod.GET)
    public ModelAndView UserDetails(@ModelAttribute("user")User user, HttpSession session) {
        User user1 = session.getAttribute ("userObject") != null ? (User) session.getAttribute ("userObject") : null;
        if (user1 != null) {
            ModelAndView mv = new ModelAndView ("user");
            mv.addObject ("user", user1);
            return mv;


    }
    return new ModelAndView ("index");
}

    @RequestMapping(value = "/Update", method = RequestMethod.POST)
    public  ModelAndView UpdateUser(@ModelAttribute("user") User user,HttpSession session)
    {
        User user1 = session.getAttribute ("userObject") != null ? (User) session.getAttribute ("userObject") : null;

        if (user1 != null) {
            ModelAndView mv = new ModelAndView ("success");
            Boolean res = userService.UpdateUser (user);
            if (res == true){
                return mv;
             }  else

        return new ModelAndView ("user");
    }

        return new ModelAndView ("Dashboard");
    }



}

