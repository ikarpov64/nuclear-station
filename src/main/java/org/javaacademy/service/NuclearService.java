package org.javaacademy.service;

import org.javaacademy.station.NuclearStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NuclearService {
    private final NuclearStation nuclearStation;

    @Autowired
    public NuclearService(NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
    }

    public void startNuclearStation() {
        nuclearStation.start(3);
    }

}
