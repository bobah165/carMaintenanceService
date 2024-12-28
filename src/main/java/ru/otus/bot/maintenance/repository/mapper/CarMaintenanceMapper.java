package ru.otus.bot.maintenance.repository.mapper;

import org.springframework.stereotype.Component;
import ru.otus.bot.maintenance.data.CarMaintenanceDto;
import ru.otus.bot.maintenance.repository.model.CarMaintenance;

@Component
public class CarMaintenanceMapper {

    public CarMaintenanceDto convertFromEntityToDto(CarMaintenance carMaintenance) {
        return new CarMaintenanceDto().setUserId(carMaintenance.getUserId())
                                      .setMaintenanceType(carMaintenance.getMaintenanceType())
                                      .setValue(carMaintenance.getValue());
    }

    public CarMaintenance convertFromDtoToEntity(CarMaintenanceDto carMaintenanceDto) {
        return new CarMaintenance().setUserId(carMaintenanceDto.getUserId())
                                   .setMaintenanceType(carMaintenanceDto.getMaintenanceType())
                                   .setValue(carMaintenanceDto.getValue());
    }
}
