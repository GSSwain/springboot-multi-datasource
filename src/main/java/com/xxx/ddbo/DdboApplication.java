package com.xxx.ddbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.xxx.ddbo.suiteanalytics.interfaces.ReturnReasonsBrandRepository;
import com.xxx.ddbo.suiteanalytics.logic.CustomSegments;

import com.xxx.ddbo.postgresql.interfaces.CustomListValuesRepository;
import com.xxx.ddbo.postgresql.logic.CustomLists;

@SpringBootApplication
@ComponentScan("com.xxx.ddbo")
public class DdboApplication implements CommandLineRunner {

    @Autowired
    private ReturnReasonsBrandRepository rrRepo;
    
    @Autowired
    private CustomListValuesRepository customListValuesRepository;

    public static void main(String[] args) {
        SpringApplication.run(DdboApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CustomSegments cs = new CustomSegments(rrRepo);
        cs.printReturnReasonBrand();
    		
        System.out.println("*************************      rrRepo print complete");
    		

        CustomLists cl = new CustomLists(customListValuesRepository);
        cl.printCustomListValues();
        
        System.out.println("*************************      customListValuesRepository print complete");
    }
}
