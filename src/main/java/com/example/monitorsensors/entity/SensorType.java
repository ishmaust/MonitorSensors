package com.example.monitorsensors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_type")
public class SensorType implements EntityEnumMarker {
  @Id
  @Column(name = "type_name", nullable = false, length = 20, unique = true)
  private String typeName;

  public SensorType(){}

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
}
