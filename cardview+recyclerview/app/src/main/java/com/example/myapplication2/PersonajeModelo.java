package com.example.myapplication2;

public class PersonajeModelo {
    private String nombre, posicion;
    private int imgPersonaje;

    public PersonajeModelo(String nombre, String posicion, int imgPersonaje) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.imgPersonaje = imgPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getImgPersonaje() {
        return imgPersonaje;
    }

    public void setImgPersonaje(int imgPersonaje) {
        this.imgPersonaje = imgPersonaje;
    }
}
