package ru.otus.bot.maintenance.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class CarConfig {
    @Value("${car.param.maintenance.schedule}")
    private int schedule;
    @Value("${car.param.maintenance.total}")
    private int total;
    @Value("${car.param.maintenance.reminder}")
    private int reminder;
}
