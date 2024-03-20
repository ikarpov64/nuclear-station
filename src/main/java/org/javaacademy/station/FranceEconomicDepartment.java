package org.javaacademy.station;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Component
@Profile("france")
public class FranceEconomicDepartment extends EconomicDepartment {
    @Value("${country.france.discount}")
    private double discountEachBillion;
    @Value("${country.france.cost}")
    private double costPerUnit;
    @Value("${country.france.name}")
    private String name;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {

        long base = 1_000_000_000L;

        BigDecimal multiplier = new BigDecimal(costPerUnit);
        BigDecimal discount = BigDecimal.valueOf(discountEachBillion);
        BigDecimal sum = BigDecimal.ZERO;

        long billionsOfKwH = countElectricity / base;
        for (int i = 0; i < billionsOfKwH; i++) {
            sum = sum.add(BigDecimal.valueOf(base).multiply(multiplier));
            multiplier = multiplier.multiply(discount);
        }
        long remainingKwH = countElectricity % base;
        sum = sum.add(BigDecimal.valueOf(remainingKwH).multiply(multiplier));

        return sum;
    }

    @Override
    public String toString() {
        return "FranceEconomicDepartment{" +
                "name='" + name + '\'' +
                '}';
    }
}
