package com.example.monitorsensors.utils;

import com.example.monitorsensors.DTO.DtoMarker;
import com.example.monitorsensors.entity.EntityMarker;

public interface DtoConverter <dto extends DtoMarker, entity extends EntityMarker>{

  entity getEntity(dto dto);
  dto getDto(entity entity);
}
