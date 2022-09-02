package com.example.monitorsensors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor implements EntityMarker{
  @Id
  @Column(name = "name", nullable = false, length = 30, unique = true)
  private String name;

  @Column(name = "model", nullable = false, length = 30)
  private String model;

  @Column(name = "range_from", nullable = false)
  private Integer rangeFrom;

  @Column(name = "range_to", nullable = false)
  private Integer rangeTo;
  @ManyToOne(targetEntity = SensorType.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "type_name", referencedColumnName = "type_name")
  private SensorType type;
  @ManyToOne(targetEntity = SensorUnit.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "unit_name", referencedColumnName = "unit_name")
  private SensorUnit unit;

  @Column(name = "location", nullable = false, length = 40)
  private String location;

  @Column(name = "description", nullable = false, length = 40)
  private String description;

  public Sensor(){}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getRangeFrom() {
    return rangeFrom;
  }

  public void setRangeFrom(Integer rangeFrom) {
    this.rangeFrom = rangeFrom;
  }

  public Integer getRangeTo() {
    return rangeTo;
  }

  public void setRangeTo(Integer rangeTo) {
    this.rangeTo = rangeTo;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SensorType getType() { return type; }

  public void setType(SensorType type) { this.type = type; }

  public SensorUnit getUnit() { return unit; }

  public void setUnit(SensorUnit unit) { this.unit = unit; }

}
