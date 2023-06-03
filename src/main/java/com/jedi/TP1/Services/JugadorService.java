package com.jedi.TP1.Services;

import com.jedi.TP1.models.Jugador;

import java.util.Optional;

public interface JugadorService {


    Optional<Jugador> buscarNombreJugador(String nombre);
}
