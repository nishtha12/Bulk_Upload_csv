package com.demo.bulkupload.demo.Batch;


import com.demo.bulkupload.demo.Model.User;
import com.demo.bulkupload.demo.Repository.UserRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbWriter implements ItemWriter<User> {

    @Autowired
    private UserRepo userRepository;

    @Override
    public void write(List<? extends User> users) throws Exception {

        System.out.println("Data Saved for Users: " + users);
        userRepository.save(users);
    }
}