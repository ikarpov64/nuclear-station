package org.javaacademy.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.station.NuclearStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NuclearService {
    @Autowired
    private final NuclearStation nuclearStation;

    public void startNuclearStation() {
        nuclearStation.start(3);
    }

}
