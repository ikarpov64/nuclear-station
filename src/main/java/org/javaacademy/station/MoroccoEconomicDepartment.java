package org.javaacademy.station;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("morocco")
@ConfigurationProperties(prefix = "country.morocco")
public class MoroccoEconomicDepartment extends EconomicDepartment {
    private double increasedCost;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        long base = 5_000_000_000L;

        if (countElectricity <= base) {
            return BigDecimal.valueOf(countElectricity).multiply(BigDecimal.valueOf(getCostPerUnit()));
        }

        BigDecimal sum = BigDecimal.valueOf(base).multiply(BigDecimal.valueOf(getCostPerUnit()));
        long remainingKwH = countElectricity - base;
        sum = sum.add(BigDecimal.valueOf(remainingKwH).multiply(BigDecimal.valueOf(increasedCost)));
        return sum;
    }
}
