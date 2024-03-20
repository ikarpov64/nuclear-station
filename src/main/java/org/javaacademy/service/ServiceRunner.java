package org.javaacademy.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServiceRunner implements ApplicationRunner {
    private final NuclearService nuclearService;

    public ServiceRunner(NuclearService myService) {
        this.nuclearService = myService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nuclearService.startNuclearStation();
    }
}
