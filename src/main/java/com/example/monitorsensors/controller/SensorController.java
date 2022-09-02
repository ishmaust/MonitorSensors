package com.example.monitorsensors.controller;

import com.example.monitorsensors.DTO.SensorDto;
import com.example.monitorsensors.entity.Sensor;
import com.example.monitorsensors.repository.SensorRepositoryImpl;
import com.example.monitorsensors.service.DaoService;
import com.example.monitorsensors.service.SensorService;
import com.example.monitorsensors.utils.DtoConverter;
import com.example.monitorsensors.utils.SensorDtoConverter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorController {

  private final DaoService<Sensor> sensorService;
  private final DtoConverter<SensorDto, Sensor> sensorDtoConverter;

  @Autowired
  public SensorController(SensorService sensorService, SensorDtoConverter sensorDtoConverter) {
    this.sensorService = sensorService;
    this.sensorDtoConverter = sensorDtoConverter;
  }

  @GetMapping(value = "{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Sensor> getSensorById(@PathVariable("name") @NotBlank @Size(max = 30) String name) {
    return new ResponseEntity<>(sensorService.getEntity(name), HttpStatus.OK);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Sensor>> getSensorsByFilter(@RequestParam(value = "filter", defaultValue = "") String filter) {
    return new ResponseEntity<>(sensorService.getEntitiesByFilter(filter), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Sensor> addNewSensor(@RequestBody @Valid SensorDto sensorDto) {
    Sensor entity = sensorService.createEntity(sensorDtoConverter.getEntity(sensorDto));
    return new ResponseEntity<>(entity, HttpStatus.CREATED);
  }

  @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Sensor> updateSensor(@RequestBody @Valid SensorDto sensorDto) {
    Sensor entity = sensorService.updateEntity(sensorDtoConverter.getEntity(sensorDto));
    return new ResponseEntity<>(entity, HttpStatus.CREATED);
  }

}
