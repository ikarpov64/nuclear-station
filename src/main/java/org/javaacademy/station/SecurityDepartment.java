package org.javaacademy.station;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@RequiredArgsConstructor
@Component
@Getter
public class SecurityDepartment {
    private final NuclearStation nuclearStation;
    private int accidentCountPeriod;

    public void addAccident() {
        accidentCountPeriod ++;
    }

//    public int getCountAccidents() {
//        return accidentCountPeriod;
//    }

    public void reset() {
        nuclearStation.incrementAccident(accidentCountPeriod);
        accidentCountPeriod = 0;
    }
}
