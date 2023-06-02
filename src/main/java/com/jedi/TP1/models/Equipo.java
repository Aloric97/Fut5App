package com.jedi.TP1.models;

import java.time.LocalDate;
import java.util.List;

public class Equipo {

    private Long id_equipo;
    private String nombre;

    private LocalDate fechaCreacion;

    private List<Jugador> jugadores;

    private Entrenador entrenador;


    public Equipo(Long id_equipo, String nombre, LocalDate fechaCreacion, List<Jugador> jugadores, Entrenador entrenador) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.jugadores = jugadores;
        this.entrenador = entrenador;
    }

    public Long getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
