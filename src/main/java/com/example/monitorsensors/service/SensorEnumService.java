package com.example.monitorsensors.service;

import com.example.monitorsensors.entity.SensorType;
import com.example.monitorsensors.entity.SensorUnit;
import com.example.monitorsensors.exception.NotFoundEntityException;
import com.example.monitorsensors.repository.EnumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorEnumService {

  private final EnumRepository<SensorType> sensorTypeRepository;
  private final EnumRepository<SensorUnit> sensorUnitRepository;

  @Autowired
  public SensorEnumService(EnumRepository<SensorType> sensorTypeRepository,
      EnumRepository<SensorUnit> sensorUnitRepository) {
    this.sensorTypeRepository = sensorTypeRepository;
    this.sensorUnitRepository = sensorUnitRepository;
  }

  public SensorType getSensorType(String name) {
    return sensorTypeRepository.findByName(name.toLowerCase())
        .orElseThrow(() -> new NotFoundEntityException(String
            .format("Sensor type with %s name not found", name)));
  }

  public SensorUnit getSensorUnit(String name) {
    return name != null ? sensorUnitRepository.findByName(name.toLowerCase())
        .orElseThrow(() -> new NotFoundEntityException(String
            .format("Sensor unit with %s name not found", name))) : null;
  }
}
