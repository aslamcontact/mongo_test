package com.aslam.mycontact;

import com.aslam.mycontact.businesslayer.DataAcessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestingCommandLine implements CommandLineRunner {
    @Autowired
    DataAcessLogic dataAcessLogic;
    @Override
    public void run(String... args) throws Exception {



        dataAcessLogic.productTest2();



    }
}
