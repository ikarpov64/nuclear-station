package org.javaacademy.station;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
@Component
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    @Lazy
    private final SecurityDepartment securityDepartment;
    private final EconomicDepartment economicDepartment;
    private BigDecimal totalEnergyProduced = new BigDecimal(0);
    private int accidentCountAllTime;

    private void startYear() {
        System.out.println("Атомная станция начала работу.");
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
        System.out.printf("Доход за год составил: %.2f %s\n",
                economicDepartment.computeYearIncomes(totalEnergyProduced.longValue()),
                economicDepartment.getCurrency());
        totalEnergyProduced = new BigDecimal(0);
        securityDepartment.reset();
    }

    public void start(int year) {
        System.out.printf("Действие происходит в стране: %s\n", economicDepartment.getName());
        for (int i = 0; i < year; i++) {
            startYear();
        }
    }

    public void incrementAccident(int count) {
        accidentCountAllTime += count;
    }
}
