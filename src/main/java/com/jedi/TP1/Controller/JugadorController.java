package com.jedi.TP1.Controller;


import com.jedi.TP1.Services.Imp.JugadorServiceImp;
import com.jedi.TP1.models.Jugador;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class JugadorController {

    private JugadorServiceImp jugadorServiceImp;

    public JugadorController(){
        jugadorServiceImp= new JugadorServiceImp();
    }


    public Optional<Jugador> buscarJugadorNombre(String nombre){
        return jugadorServiceImp.buscarNombreJugador(nombre);
    }
}
