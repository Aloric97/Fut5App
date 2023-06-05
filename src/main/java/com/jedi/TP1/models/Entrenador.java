package com.jedi.TP1.models;

public class Entrenador extends Persona{


    private static Long id_entrenador=1L;
    private Integer edad;

    private Equipo equipo;

    public Entrenador(String nombre, String apellido, Integer edad){
        super(nombre,apellido);
        id_entrenador++;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }

    public Entrenador(String nombre, String apellido, Integer edad, Equipo equipo) {
        super(nombre, apellido);
        id_entrenador++;
        this.edad=edad;
        this.equipo=equipo;
    }

    public static Long getId_entrenador() {
        return id_entrenador;
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
