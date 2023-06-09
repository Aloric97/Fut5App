package com.jedi.TP1.Services;

import com.jedi.TP1.enums.Posiciones;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;

import java.util.Optional;

public interface JugadorService {


    Jugador agregarJugador (String nombreJugador, String apellidoJugador, Double alturaJugador, Posiciones posicion,Integer cantidadGoles,Boolean esCapitan,Integer numeroCamiseta);

    void listarJugador();

    Optional<Jugador> buscarNombreApellidoJugador(String nombre, String apellido);

    void importarJugadores(String nombreArchivo, String equipo);

    void visualizarArchivos();

    void eliminarJugador(String nombre,String apellido);
}
