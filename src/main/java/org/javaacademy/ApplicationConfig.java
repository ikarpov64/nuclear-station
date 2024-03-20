package org.javaacademy;

import org.javaacademy.station.FranceEconomicDepartment;
import org.javaacademy.station.MoroccoEconomicDepartment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yaml")
public class ApplicationConfig {

    @Bean
    @Profile("france")
    public FranceEconomicDepartment franceEconomicDepartment() {
        return new FranceEconomicDepartment();
    }

    @Bean
    @Profile("morocco")
    public MoroccoEconomicDepartment moroccoEconomicDepartment() {
        return new MoroccoEconomicDepartment();
    }
}
