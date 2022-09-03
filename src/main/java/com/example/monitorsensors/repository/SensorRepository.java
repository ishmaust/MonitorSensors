package com.example.monitorsensors.repository;

import com.example.monitorsensors.entity.Sensor;
import java.util.List;
import java.util.Optional;


public interface SensorRepository {

  void addSensor(Sensor entity);

  void updateSensor(Sensor entity);

  Optional<Sensor> getSensorEntityByName(String name);

  List<Sensor> getSensorsByFilter(String filter);

  void deleteEntity(String name);
}
