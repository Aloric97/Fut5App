package com.jedi.TP1.Services;

import com.jedi.TP1.models.Entrenador;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;

import java.util.List;
import java.util.Optional;


public interface EquipoService {


    void agregarEquipo(Equipo equipo);

    void listarEquipos();

    Optional<Equipo> buscarEquipo(String nombre);

    void listarEquipoCapitan(Equipo equipo);

    void listarEquipoCompleto(Equipo equipo);

    void agregarJugadorAlEquipo(Equipo equipo,Jugador jugador);

    void agregarEntrenadorEquipo(Equipo equipo, Entrenador entrenador);



}
