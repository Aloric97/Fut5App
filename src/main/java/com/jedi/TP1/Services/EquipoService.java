package com.jedi.TP1.Services;

import com.jedi.TP1.models.Entrenador;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;

import java.time.LocalDate;
import java.util.Optional;


public interface EquipoService {


    Equipo agregarEquipo(String nombreEquipo, LocalDate fechaHoy);

    void listarEquipos();

    Optional<Equipo> buscarEquipo(String nombre);

    void listarEquipoCapitan(Equipo equipo);

    void listarEquipoCompleto(Equipo equipo);

    void agregarJugadorAlEquipo(Equipo equipo,Jugador jugador);

    void agregarEntrenadorEquipo(Equipo equipo, Entrenador entrenador);

    void eliminarEquipo(String nombre);

    void ordenarPorNombreJugadores(String nombre);

    void  ordenarPorCamiseta(String nombre);

    void ordenarPorPosicionCamiseta(String nombre);


    void exportarEquipo(Equipo equipo);


}
