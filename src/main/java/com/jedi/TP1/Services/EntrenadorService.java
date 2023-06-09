package com.jedi.TP1.Services;

import com.jedi.TP1.models.Entrenador;

import java.util.Optional;

public interface EntrenadorService {


    Entrenador agregarEntrenador(String nombreEntrenador, String apellidoEntrenador,Integer edadEntrenador);

    void listarEntrenadores();

    void eliminarEntrenador(String nombre);

    Optional<Entrenador> buscarEntrenador(String nombre);


}
