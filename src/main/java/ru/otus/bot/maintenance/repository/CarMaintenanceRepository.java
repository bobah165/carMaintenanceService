package ru.otus.bot.maintenance.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.bot.maintenance.data.MaintenanceType;
import ru.otus.bot.maintenance.repository.model.CarMaintenance;


@Repository
public interface CarMaintenanceRepository extends JpaRepository<CarMaintenance, String> {

    CarMaintenance findByUserIdAndMaintenanceType(String userId, MaintenanceType maintenanceType);
    List<CarMaintenance> findByUserId(String userId);
}
