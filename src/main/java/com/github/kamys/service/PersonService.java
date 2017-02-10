package com.github.kamys.service;

import com.github.kamys.entity.Person;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * This service provide operation with database.
 */
public class PersonService implements Service {
    private static final Logger LOGGER = Logger.getLogger(PersonService.class);
    private EntityManager em = Persistence
            .createEntityManagerFactory("testUnite")
            .createEntityManager();

    public Person add(Person person) {
        LOGGER.info("add: person = " + person);
        em.getTransaction().begin();
        Person personFromDB = em.merge(person);
        em.getTransaction().commit();
        LOGGER.info("return - " + personFromDB);
        return personFromDB;
    }

    public void delete(String id) {
        LOGGER.info("delete: id = " + id);
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Person get(String id) {
        LOGGER.info("get: id = " + id);
        return em.find(Person.class, id);
    }
}
