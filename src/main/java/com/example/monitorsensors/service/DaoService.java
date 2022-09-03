package com.example.monitorsensors.service;

import com.example.monitorsensors.entity.EntityMarker;
import java.util.List;
import java.util.Optional;

public interface DaoService<entity extends EntityMarker> {

  entity getEntity(String name);

  Optional<entity> getOptionalEntity(String name);

  List<entity> getEntitiesByFilter(String filter);

  entity createEntity(entity entity);

  entity updateEntity(entity entity);

  entity deleteEntity(String name);

}
