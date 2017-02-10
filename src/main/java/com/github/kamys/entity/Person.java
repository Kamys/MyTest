package com.github.kamys.entity;

import javax.persistence.*;

/**
 * This entity for person.
 */
@Entity
@Table(name = "Persons", schema = "example_2")
public class Person {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Person() {
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
