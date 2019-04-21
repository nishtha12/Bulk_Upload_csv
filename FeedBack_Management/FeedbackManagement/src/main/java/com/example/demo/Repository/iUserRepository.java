package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepository extends CrudRepository<User,Integer> {

    User findByIdAndPass(int id,String pass);


}
