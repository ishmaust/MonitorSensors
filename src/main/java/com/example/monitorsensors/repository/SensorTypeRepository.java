package com.example.monitorsensors.repository;

import com.example.monitorsensors.entity.SensorType;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SensorTypeRepository implements EnumRepository<SensorType> {

  private final SessionFactory sessionFactory;

  @Autowired
  public SensorTypeRepository(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public Optional<SensorType> findByName(String name) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    Optional<SensorType> sensorType = session.byId(SensorType.class).loadOptional(name);
    transaction.commit();
    session.close();
    return sensorType;
  }
}
