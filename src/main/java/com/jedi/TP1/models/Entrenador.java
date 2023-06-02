package com.jedi.TP1.models;

public class Entrenador extends Persona{


    private static Long id_entrenador;
    private Integer edad;

    private Equipo equipo;

    public Entrenador(String nombre, String apellido, Integer edad, Equipo equipo) {
        super(nombre, apellido);
        id_entrenador++;
        this.edad=edad;
        this.equipo=equipo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
