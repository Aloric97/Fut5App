package com.jedi.TP1.Services.Imp;

import com.jedi.TP1.Services.JugadorService;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImp implements JugadorService {

    private List<Jugador> listaJugador= new ArrayList<>();


    //voy a usar funciones lambdas para tratar las busquedas
    @Override
    public Optional<Jugador> buscarNombreJugador(String nombre) {

        return listaJugador.stream().filter(jugador -> jugador.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }
}
