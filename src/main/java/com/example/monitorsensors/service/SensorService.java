package com.example.monitorsensors.service;

import com.example.monitorsensors.entity.Sensor;
import com.example.monitorsensors.exception.NotFoundEntityException;
import com.example.monitorsensors.repository.SensorRepositoryImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService implements DaoService<Sensor> {

  private final SensorRepositoryImpl sensorRepository;

  @Autowired
  public SensorService(SensorRepositoryImpl sensorRepository) {
    this.sensorRepository = sensorRepository;
  }

  @Override
  public Sensor getEntity(String name) {
    return sensorRepository.getSensorEntityByName(name).orElseThrow(() -> new NotFoundEntityException("Sensor with this name not found"));
  }
  
  @Override
  public Optional<Sensor> getOptionalEntity(String name) {
    return sensorRepository.getSensorEntityByName(name);
  }
  
  @Override
  public Sensor createEntity(Sensor sensor) {
    return null;
  }

  @Override
  public Sensor updateEntity(int id, Sensor sensor) {
    return null;
  }

  @Override
  public void deleteEntity(int id) {

  }
}
