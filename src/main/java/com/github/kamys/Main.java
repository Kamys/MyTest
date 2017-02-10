package com.github.kamys;

import com.github.kamys.entity.Gender;
import com.github.kamys.entity.Person;
import com.github.kamys.service.PersonServiceHibernate;
import com.github.kamys.service.Service;

import java.util.Random;

/**
 * Created by HNKNTOC on 04.02.2017.
 * TODO: Add doc.
 */
public class Main {
    public static void main(String[] args) {
        Service service = new PersonServiceHibernate();
        service.add(new Person("Vasa",19,Gender.MEN));
    }

    private static void go() {
        Service service = new PersonServiceHibernate();

        System.out.println("Start");
        for (int i = 0; i < 100; i++) {
            String name = "Person " + i;
            Random random = new Random();
            Person person = new Person(name, random.nextInt(30) + 19, Gender.values()[random.nextInt(2)]);
            service.add(person);
        }
        System.out.println("Stop");
    }
}
