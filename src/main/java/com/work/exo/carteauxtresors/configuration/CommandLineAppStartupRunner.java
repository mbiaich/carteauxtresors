package com.work.exo.carteauxtresors.configuration;

import com.work.exo.carteauxtresors.service.IGlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final IGlobalService globalService;

    @Autowired
    public CommandLineAppStartupRunner(IGlobalService globalService) {
        this.globalService = globalService;
    }

    @Override
    public void run(String... args) throws Exception {
        globalService.launch();
    }

}
