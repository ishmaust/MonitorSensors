package com.example.monitorsensors.utils;

import com.example.monitorsensors.DTO.SensorDto;
import com.example.monitorsensors.entity.Sensor;
import com.example.monitorsensors.entity.SensorType;
import com.example.monitorsensors.entity.SensorUnit;

public class SensorBuilder {

  private String name;
  private String model;
  private Integer rangeFrom;
  private Integer rangeTo;
  private SensorType type;
  private SensorUnit unit;
  private String location;
  private String description;

  public SensorBuilder() {

  }

  public SensorBuilder(SensorDto sensorDto, SensorType sensorType, SensorUnit sensorUnit) {
    this.type = sensorType;
    this.unit = sensorUnit;
    this.name = sensorDto.getTitle();
    this.model = sensorDto.getModel();
    this.rangeFrom = sensorDto.getRange().getFrom();
    this.rangeTo = sensorDto.getRange().getTo();
    this.description = sensorDto.getDescription();
    this.location = sensorDto.getLocation();

  }

  public SensorBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public SensorBuilder setModel(String model) {
    this.model = model;
    return this;
  }

  public SensorBuilder setRangeFrom(Integer rangeFrom) {
    this.rangeFrom = rangeFrom;
    return this;
  }

  public SensorBuilder setRangeTo(Integer rangeTo) {
    this.rangeTo = rangeTo;
    return this;
  }

  public SensorBuilder setType(SensorType type) {
    this.type = type;
    return this;
  }

  public SensorBuilder setUnit(SensorUnit unit) {
    this.unit = unit;
    return this;
  }

  public SensorBuilder setLocation(String location) {
    this.location = location;
    return this;
  }

  public SensorBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public Sensor build() {
    Sensor sensor = new Sensor();
    sensor.setName(this.name);
    sensor.setModel(this.model);
    sensor.setRangeFrom(this.rangeFrom);
    sensor.setRangeTo(this.rangeTo);
    sensor.setDescription(this.description);
    sensor.setLocation(this.location);
    sensor.setType(this.type);
    sensor.setUnit(this.unit);
    return sensor;
  }
}
