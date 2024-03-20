package org.javaacademy.station;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Component
@Profile("morocco")
public class MoroccoEconomicDepartment extends EconomicDepartment {
    @Value("${country.morocco.cost}")
    private double costPerUnit;
    @Value("${country.morocco.increasedCost}")
    private double increasedCost;
    @Value("${country.morocco.name}")
    private String name;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        long base = 5_000_000_000L;

        if (countElectricity <= base) {
            return BigDecimal.valueOf(countElectricity).multiply(BigDecimal.valueOf(costPerUnit));
        }

        BigDecimal sum = BigDecimal.valueOf(base).multiply(BigDecimal.valueOf(costPerUnit));
        long remainingKwH = countElectricity - base;
        sum = sum.add(BigDecimal.valueOf(remainingKwH).multiply(BigDecimal.valueOf(increasedCost)));
        return sum;
    }

    @Override
    public String toString() {
        return "MoroccoEconomicDepartment{" +
                "name='" + name + '\'' +
                '}';
    }
}
