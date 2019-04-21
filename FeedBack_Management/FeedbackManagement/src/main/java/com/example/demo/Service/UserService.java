package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.iUserRepository;

@Service
public class UserService {

    @Autowired
    public iUserRepository iUserRepositorys;

   public User checkUser(int id, String pass)
    {
       return iUserRepositorys.findByIdAndPass (id,pass);
    }

    public boolean UpdateUser(User user) {

        User user2 = iUserRepositorys.save (user);
        System.out.println ("Update user"+user2);
        if (user2 == null) {
            return false;
        }else
            return true;
    }
}
