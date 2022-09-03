package com.example.monitorsensors.utils;

import com.example.monitorsensors.DTO.RangeDto;
import com.example.monitorsensors.DTO.SensorDto;
import com.example.monitorsensors.entity.Sensor;
import com.example.monitorsensors.exception.RangeException;
import com.example.monitorsensors.service.SensorEnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SensorDtoConverter implements DtoConverter<SensorDto, Sensor> {
  private final SensorEnumService enumService;

  @Autowired
  public SensorDtoConverter(SensorEnumService enumService) {
    this.enumService = enumService;
  }

  @Override
  public Sensor getEntity(SensorDto sensorDto) {
    if(!sensorDto.getRange().rangeValid()) {
      throw new RangeException(sensorDto.getRange());
    }

    return new SensorBuilder(sensorDto, enumService.getSensorType(sensorDto.getType()),
            enumService.getSensorUnit(sensorDto.getUnit())).build();

  }

  @Override
  public SensorDto getDto(Sensor sensor) {
    SensorDto sensorDto = new SensorDto();
    RangeDto range = new RangeDto();

    range.setFrom(sensor.getRangeFrom());
    range.setTo(sensor.getRangeTo());

    sensorDto.setTitle(sensor.getName());
    sensorDto.setModel(sensor.getModel());
    sensorDto.setLocation(sensor.getLocation());
    sensorDto.setDescription(sensor.getDescription());
    sensorDto.setType(sensor.getType().getTypeName());
    sensorDto.setUnit(sensor.getUnit().getUnitName());
    sensorDto.setRange(range);

    return sensorDto;
  }
}
