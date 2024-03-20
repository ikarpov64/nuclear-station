package org.javaacademy.station;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
@Component
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    @Lazy
    @Autowired
    private final SecurityDepartment securityDepartment;
    private BigDecimal totalEnergyProduced = new BigDecimal(0);
    private int accidentCountAllTime;
    private final EconomicDepartment economicDepartment;

    private void startYear() {
        System.out.println("Атомная станция начала работу.");
//        long oneYearEnergyProduced = 0;
        for (int i = 0; i < 365; i++) {
            try {
                totalEnergyProduced = totalEnergyProduced.add(BigDecimal.valueOf(reactorDepartment.run()));
                reactorDepartment.stop();
            } catch (Exception e) {
                System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет! "
                        + e.getMessage());
            }
        }

        System.out.printf("Атомная станция закончила работу. За год Выработано %s киловатт/часов\n",
                totalEnergyProduced.toString());
        System.out.printf("Количество инцидентов за год: %s\n", securityDepartment.getAccidentCountPeriod());
        System.out.printf("Доход за год составил: %s\n",
                economicDepartment.computeYearIncomes(totalEnergyProduced.longValue()));
        totalEnergyProduced = new BigDecimal(0);
        securityDepartment.reset();
    }

    public void start(int year) {
        System.out.printf("Действие происходит в стране: %s\n", economicDepartment);
        for (int i = 0; i < year; i++) {
            startYear();
        }
    }

    public void incrementAccident(int count) {
        accidentCountAllTime += count;
    }
}
