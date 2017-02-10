package com.github.kamys.service;

import com.github.kamys.entity.Person;

/**
 * Created by Kamys on 10.02.2017.
 * TODO: Add doc.
 */
public interface Service {
    Person add(Person person);
    void delete(String id);
    Person get(String id);

}
