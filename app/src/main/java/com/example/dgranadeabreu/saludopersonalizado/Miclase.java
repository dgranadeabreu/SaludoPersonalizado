package com.example.dgranadeabreu.saludopersonalizado;

import java.io.Serializable;

public class Miclase implements Serializable
{
    private static  final  long SERIEV=12;
    String nombre;
    int edad;
    public Miclase(String nombre,int edad)
    {
        this.nombre=nombre;
        this.edad=edad;
    }

}