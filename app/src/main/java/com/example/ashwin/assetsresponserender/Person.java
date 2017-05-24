package com.example.ashwin.assetsresponserender;

/**
 * Created by ashwin on 23/5/17.
 */

public class Person {

    private String name, city, country;
    private int age;

    public Person() { }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
