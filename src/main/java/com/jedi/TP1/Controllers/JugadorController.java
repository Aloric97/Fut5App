package com.jedi.TP1.Controllers;


import com.jedi.TP1.Services.Imp.JugadorServiceImp;
import com.jedi.TP1.enums.Posiciones;
import com.jedi.TP1.models.Jugador;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class JugadorController {

    private final JugadorServiceImp jugadorServiceImp;

    public JugadorController(){
        jugadorServiceImp= new JugadorServiceImp();
    }


    public Optional<Jugador> buscarNombreApellidoJugador(String nombre,String apellido){
        return jugadorServiceImp.buscarNombreApellidoJugador(nombre,apellido);
    }

    public Jugador agregarJugador(String nombre, String apellido, Double altura, Posiciones posicion, int cantidadGoles, boolean esCapitan,int numeroCamiseta){
        Jugador jugador= new Jugador(nombre,apellido,altura,posicion,cantidadGoles,esCapitan,numeroCamiseta);
        jugadorServiceImp.agregarJugador(jugador);
        return jugador;
    }

    public void listarJugador(){
        jugadorServiceImp.listarJugador();
    }



}
