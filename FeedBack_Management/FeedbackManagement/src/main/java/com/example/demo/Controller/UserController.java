package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mv = new ModelAndView ("index");
        mv.addObject ("user", new User ());
        return mv;
    }

    @RequestMapping(value = "/logged-in" , method = RequestMethod.POST)
    public ModelAndView UserLogin(@ModelAttribute("user")User user,int id, String pass, HttpSession session)
    {   System.out.println("bhai apna chalega "+user+" "+id+" "+pass);
        User result = userService.checkUser (id,pass);
        if(result!=null){
            session.setAttribute ("userObject",result);
            System.out.println (result.getRole ());

            if(result.getRole().equals ("Student")){
                System.out.println (result.getRole ());
                return new ModelAndView ("redirect:/Student") ;
            }else  if(result.getRole().equals ("Teacher")){
                return new ModelAndView ("redirect:/Faculty") ;
            }else if(result.getRole ().equals ("admin")) {
                return new ModelAndView ("redirect:/Dashboard") ;
            }else if(result.getRole ().equals ("director")) {
                return new ModelAndView ("redirect:/director") ;
            }
        }
        return new ModelAndView ("error");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session)
    {
        session.removeAttribute ("userObject");
        session.invalidate();
        return new ModelAndView ("redirect:/index");
    }
}
