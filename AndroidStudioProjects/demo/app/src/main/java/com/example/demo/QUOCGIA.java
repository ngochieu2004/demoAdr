package com.example.demo;

import java.io.Serializable;

public class QUOCGIA implements Serializable {
    int flag;
    String name, population;
    public QUOCGIA(int flag, String name, String population)
    {
        this.flag=flag;
        this.name=name;
        this.population=population;
    }
}
