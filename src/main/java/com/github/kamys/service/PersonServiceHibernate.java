package com.github.kamys.service;

import com.github.kamys.entity.Person;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;



/**
 * This service provide operation with database. Implements through Hibernate.
 */
public class PersonServiceHibernate implements Service {
    private static final Logger LOGGER = Logger.getLogger(PersonServiceHibernate.class);
    private SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .configure();

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());

        return configuration.buildSessionFactory(builder.build());
    }

    @Override
    public Person add(Person person) {
        LOGGER.info("add: person - " + person);
        Transaction tr = null;
        SessionFactory factory = createSessionFactory();
        Session session = factory.openSession();
        try {
            tr = session.beginTransaction();
            Serializable save = session.save(person);
            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            LOGGER.warn(e);
        } finally {
            session.close();
            factory.close();
        }
        return null;
    }

    @Override
    public void delete(String id) {
        LOGGER.info("delete: id - " + id);

    }

    @Override
    public Person get(String id) {
        LOGGER.info("get: id - " + id);
        return null;
    }
}
