package org.javaacademy.station;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.javaacademy.exception.NuclearFuelIsEmptyException;
import org.javaacademy.exception.ReactorWorkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
//@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class ReactorDepartment {
    @Autowired
    @Lazy
    private final SecurityDepartment securityDepartment;
    private final double energyProduced = 10_000_000;
    private final int limitRunInARow = 100;
    private boolean isWorkNow;
    private int runCount;

    public double run() {
        if (isWorkNow) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже работает.");
        }

        isWorkNow = true;
        if (runCount == limitRunInARow) {
            runCount = 0;
            stop();
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException("В реакторе отсутствует топливо.");
        }
        runCount ++;
        return energyProduced;
    }

    public void stop() {
        if (!isWorkNow) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже выключен.");
        }
        isWorkNow = false;
    }
}
