package ru.otus.bot.maintenance.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.otus.bot.maintenance.data.MaintenanceType;

@Data
@Entity
@Table(schema = "general", name = "maintenance")
@Accessors(chain = true)
@NoArgsConstructor
public class CarMaintenance {
    @Id
    private String id;
    @Column(name = "user_id")
    private String userId;
    private int value;
    @Column(name = "maintenance")
    @Enumerated(EnumType.STRING)
    private MaintenanceType maintenanceType;

}
