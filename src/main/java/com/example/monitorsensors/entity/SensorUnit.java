package com.example.monitorsensors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_unit")
public class SensorUnit implements EntityEnumMarker{
  @Id
  @Column(name = "unit_name", nullable = false, length = 20, unique = true)
  private String unitName;

  public SensorUnit() {}

  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }
}
