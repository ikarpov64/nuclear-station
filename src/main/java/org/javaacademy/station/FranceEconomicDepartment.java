package org.javaacademy.station;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Getter
//@Setter
@Component
@Profile("france")
@ConfigurationProperties(prefix = "country.france")
public class FranceEconomicDepartment extends EconomicDepartment {
    private double discountEachBillion;

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {

        long base = 1_000_000_000L;

        BigDecimal multiplier = BigDecimal.valueOf(getCostPerUnit());
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
}
