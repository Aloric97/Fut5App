package com.jedi.TP1.Services;

import com.jedi.TP1.models.Jugador;

import java.util.Optional;

public interface JugadorService {


    void agregarJugador (Jugador jugador);

    void listarJugador();

    Optional<Jugador> buscarNombreApellidoJugador(String nombre, String apellido);
}
