package org.javaacademy.station;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class EconomicDepartment {
    private String name;
    private String currency;
    private double costPerUnit;

    public abstract BigDecimal computeYearIncomes(long countElectricity);

}
