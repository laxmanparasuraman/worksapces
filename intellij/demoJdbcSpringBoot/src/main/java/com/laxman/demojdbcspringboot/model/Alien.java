package com.laxman.demojdbcspringboot.model;

import org.springframework.stereotype.Component;

@Component
public class Alien {

    int id;
    String tech;
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", tech='" + tech + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
