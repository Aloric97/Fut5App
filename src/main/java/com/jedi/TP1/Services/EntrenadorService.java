package com.jedi.TP1.Services;

import com.jedi.TP1.models.Entrenador;

import java.util.Optional;

public interface EntrenadorService {


    void agregarEntrenador(Entrenador entrenador);

    void listarEntrenadores();

    boolean eliminarEntrenador(String nombre);

    Optional<Entrenador> buscarEntrenador(String nombre);


}
