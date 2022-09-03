package com.example.monitorsensors.controller;

import com.example.monitorsensors.DTO.SensorDto;
import com.example.monitorsensors.entity.Sensor;
import com.example.monitorsensors.service.DaoService;
import com.example.monitorsensors.service.SensorService;
import com.example.monitorsensors.utils.DtoConverter;
import com.example.monitorsensors.utils.SensorDtoConverter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/api/sensor")
@SecurityRequirement(name = "javainuseapi")
public class SensorController {

  private final DaoService<Sensor> sensorService;
  private final DtoConverter<SensorDto, Sensor> sensorDtoConverter;

  @Autowired
  public SensorController(SensorService sensorService, SensorDtoConverter sensorDtoConverter) {
    this.sensorService = sensorService;
    this.sensorDtoConverter = sensorDtoConverter;
  }


  @GetMapping(value = "{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SensorDto> getSensorById(@PathVariable("name") @NotBlank @Size(max = 30) String name) {
    Sensor entity = sensorService.getEntity(name);
    return new ResponseEntity<>(sensorDtoConverter.getDto(entity), HttpStatus.OK);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<SensorDto>> getSensorsByFilter(@RequestParam(value = "filter", defaultValue = "") String filter) {
    List<Sensor> entitiesByFilter = sensorService.getEntitiesByFilter(filter);
    return new ResponseEntity<>(entitiesByFilter.stream().map(sensorDtoConverter::getDto).collect(Collectors.toList()), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SensorDto> addNewSensor(@RequestBody @Valid SensorDto sensorDto) {
    sensorService.createEntity(sensorDtoConverter.getEntity(sensorDto));
    return new ResponseEntity<>(sensorDto, HttpStatus.CREATED);
  }

  @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SensorDto> updateSensor(@RequestBody @Valid SensorDto sensorDto) {
    sensorService.updateEntity(sensorDtoConverter.getEntity(sensorDto));
    return new ResponseEntity<>(sensorDto, HttpStatus.CREATED);
  }

}
