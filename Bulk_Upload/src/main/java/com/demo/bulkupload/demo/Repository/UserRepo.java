package com.demo.bulkupload.demo.Repository;

import com.demo.bulkupload.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
