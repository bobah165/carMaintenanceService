package ru.otus.bot.maintenance.data;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CarMaintenanceDto {
    private String userId;
    private int value;
    private MaintenanceType maintenanceType;
}
