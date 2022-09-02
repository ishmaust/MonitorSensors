package com.example.monitorsensors.DTO;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SensorDto implements DtoMarker {

  @NotNull
  @NotBlank
  @Size(max = 30)
  private String title;

  @NotNull
  @NotBlank
  @Size(max = 15)
  private String model;

  @Valid
  private RangeDto range;

  @NotNull
  @NotBlank
  private String type;

  @NotBlank
  private String unit;

  @Size(max = 40)
  private String location;


  @Size(max = 200)
  private String description;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public RangeDto getRange() {
    return range;
  }

  public void setRange(RangeDto range) {
    this.range = range;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
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
}
