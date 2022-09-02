package com.example.monitorsensors.repository;

import com.example.monitorsensors.entity.EntityEnumMarker;
import java.util.Optional;

public interface EnumRepository<T extends EntityEnumMarker> {

  Optional<T> findByName(String name);

}
