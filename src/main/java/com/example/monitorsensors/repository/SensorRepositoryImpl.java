package com.example.monitorsensors.repository;

import com.example.monitorsensors.entity.Sensor;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SensorRepositoryImpl implements SensorRepository{

  private final SessionFactory sessionFactory;

  @Autowired
  public SensorRepositoryImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void addSensor(Sensor entity) {
      Session session = sessionFactory.openSession();
      Transaction transaction = session.beginTransaction();
      session.save(entity);

      transaction.commit();
      session.close();
  }

  @Override
  public void updateSensor(Sensor entity) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.update(entity);
    transaction.commit();
    session.close();
  }

  @Override
  public Optional<Sensor> getSensorEntityByName(String name) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    Optional<Sensor> sensor = session.createQuery("select s from Sensor s where s.name=:name",
        Sensor.class).setParameter("name", name).setMaxResults(1).getResultStream().findFirst();
    transaction.commit();
    session.close();
    return sensor;
  }

  @Override
  public List<Sensor> getSensorsByFilter(String filter) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    List<Sensor> sensors = session.createQuery(
        "select s from Sensor s where s.name like '%' || :filter || '%'",
        Sensor.class).setParameter("filter", filter).getResultList();
    transaction.commit();
    session.close();
    return sensors;
  }
}
