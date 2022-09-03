package com.example.monitorsensors.repository;

import com.example.monitorsensors.entity.SensorUnit;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SensorUnitRepository implements EnumRepository<SensorUnit> {
  private final SessionFactory sessionFactory;

  @Autowired
  public SensorUnitRepository(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public Optional<SensorUnit> findByName(String name) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    Optional<SensorUnit> sensorUnit = session.byId(SensorUnit.class).loadOptional(name);
    transaction.commit();
    session.close();
    return sensorUnit;
  }
}
