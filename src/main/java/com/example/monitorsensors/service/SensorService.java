package com.example.monitorsensors.service;

import com.example.monitorsensors.entity.Sensor;
import com.example.monitorsensors.exception.NotFoundEntityException;
import com.example.monitorsensors.repository.SensorRepositoryImpl;
import java.util.List;
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
  public List<Sensor> getEntitiesByFilter(String filter) {
    return sensorRepository.getSensorsByFilter(filter);
  }

  @Override
  public Sensor createEntity(Sensor sensor) {
    if(getOptionalEntity(sensor.getName()).isPresent()) {
      throw new NotFoundEntityException("asd");
    }

    sensorRepository.addSensor(sensor);
    return sensor;
  }

  @Override
  public Sensor updateEntity(Sensor sensor) {
    if(!getOptionalEntity(sensor.getName()).isPresent()) {
      throw new NotFoundEntityException(String.format("Sensor with %s name not found", sensor.getName()));
    }

    sensorRepository.updateSensor(sensor);
    return sensor;
  }

  @Override
  public void deleteEntity(int id) {

  }
}
