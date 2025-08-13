package org.example.entity;

import org.example.enums.VehicleLogType;

import java.time.LocalDateTime;

public class VehicleLog {
    private int logId;
    private VehicleLogType logType;
    private String description;
    private LocalDateTime creationDate;

    public VehicleLog(int logId, VehicleLogType logType, String description, LocalDateTime creationDate) {
        this.logId = logId;
        this.logType = logType;
        this.description = description;
        this.creationDate = creationDate;
    }

    public int getLogId() {
        return logId;
    }

    public VehicleLogType getLogType() {
        return logType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
