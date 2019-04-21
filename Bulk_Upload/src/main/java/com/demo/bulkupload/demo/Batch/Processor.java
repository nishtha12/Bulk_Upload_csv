package com.demo.bulkupload.demo.Batch;

import com.demo.bulkupload.demo.Model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User,User> {

    private  static final Map<String,String> deptMapper = new HashMap<> ();

    public Processor(){
        deptMapper.put ("101","SE");
        deptMapper.put ("102","Fi");
        deptMapper.put ("103","Others");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        System.out.println ("Department_code :"+deptCode);
        String deptName = deptMapper.get(deptCode);
        System.out.println("Department_name :"+deptName);
        user.setDept (deptName);
        System.out.println (String.format ("Converting %s into %s",deptCode,deptName));
        return user;
    }
}
