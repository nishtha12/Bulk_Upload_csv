package com.demo.bulkupload.demo.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class LoadData{

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public  ModelAndView desktop(){
        return new ModelAndView ("index1");
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public
    ModelAndView uploadFileHandler(@RequestParam("name") String name,
                             @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("Users/nishthaarora/Downloads/Bulk_Upload");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream (serverFile));
                stream.write(bytes);
                stream.close();

                return new ModelAndView ("redirect:/load_main");
            } catch (Exception e) {
                System.out.println ( "You failed to upload " + name + " => " + e.getMessage());
            }
        } else {
            System.out.println ( "You failed to upload " + name
                    + " because the file was empty.");
        }
    return  null;
    }

    @RequestMapping(value="/load_main",method =RequestMethod.GET)
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {


        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution: " + jobExecution.getStatus());

        System.out.println("Batch is Running...");
        while (jobExecution.isRunning()) {
            System.out.println("...");
        }
        return  jobExecution.getStatus ();
    }

}