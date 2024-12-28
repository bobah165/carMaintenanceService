package ru.otus.bot.maintenance.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.bot.maintenance.config.CarConfig;
import ru.otus.bot.maintenance.data.CarMaintenanceDto;
import ru.otus.bot.maintenance.data.MaintenanceType;
import ru.otus.bot.maintenance.repository.CarMaintenanceRepository;
import ru.otus.bot.maintenance.repository.mapper.CarMaintenanceMapper;
import ru.otus.bot.maintenance.repository.model.CarMaintenance;


@Service
@RequiredArgsConstructor
public class CarMaintenanceService {
    private final CarMaintenanceRepository repository;
    private final CarConfig config;
    private final CarMaintenanceMapper maintenanceMapper;


    @Transactional
    public void save(CarMaintenanceDto carMaintenanceDto) {
        repository.save(processCarMaintenance(carMaintenanceDto));
    }


    @Transactional(readOnly = true)
    public CarMaintenanceDto findByIdAndType(String userId, MaintenanceType maintenanceType) {
        CarMaintenance carMaintenance = getCarMaintenanceByUserIdAndType(userId, maintenanceType);
        return maintenanceMapper.convertFromEntityToDto(carMaintenance);
    }

    public List<CarMaintenanceDto> findByUserId(String userId) {
        return repository.findByUserId(userId)
                         .stream()
                         .map(maintenanceMapper::convertFromEntityToDto)
                         .collect(Collectors.toList());
    }

    private CarMaintenance processCarMaintenance(CarMaintenanceDto carMaintenanceDto) {
        CarMaintenance carMaintenance = getCarMaintenanceByUserIdAndType(carMaintenanceDto.getUserId(), carMaintenanceDto.getMaintenanceType());
        return new CarMaintenance().setMaintenanceType(carMaintenance.getMaintenanceType())
                                   .setUserId(carMaintenance.getUserId())
                                   .setId(carMaintenance.getId())
                                   .setValue(carMaintenanceDto.getValue());
    }

    private CarMaintenance getCarMaintenanceByUserIdAndType(String userId, MaintenanceType maintenanceType) {
        return Optional.ofNullable(repository.findByUserIdAndMaintenanceType(userId, maintenanceType))
                       .orElse(new CarMaintenance().setValue(getValue(maintenanceType))
                                                   .setUserId(userId)
                                                   .setMaintenanceType(maintenanceType));
    }

    private int getValue(MaintenanceType maintenanceType) {
        switch (maintenanceType) {
            case TOTAL:
                return config.getTotal();
            case REMIND:
                return config.getReminder();
            case SCHEDULE:
                return config.getSchedule();
        }
        return 0;
    }


}
