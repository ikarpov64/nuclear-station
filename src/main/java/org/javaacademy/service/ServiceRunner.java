package org.javaacademy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceRunner implements ApplicationRunner {
    @Autowired
    private final NuclearService nuclearService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nuclearService.startNuclearStation();
    }
}
