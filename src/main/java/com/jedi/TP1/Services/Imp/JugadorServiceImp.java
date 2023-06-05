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
    public Optional<Jugador> buscarNombreApellidoJugador(String nombre,String apellido) {

        return listaJugador.stream()
                .filter(jugador -> jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido))
                .findFirst();
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        listaJugador.add(jugador);
    }

    @Override
    public void listarJugador() {
        if (listaJugador.size() == 0) {
            System.out.println("no hay jugadores cargados");
        } else {
            int cantidad = 1;
            for (Jugador jugador : listaJugador) {
                System.out.println("jugador: " + cantidad);
                System.out.println("nombre: " +jugador.getNombre());
                System.out.println("apellido: " + jugador.getApellido());
                System.out.println("altura: " + jugador.getAltura() + " Metros");
                System.out.println("posicion:"+ jugador.getPosiciones());
                System.out.println("cantidad de goles: "+ jugador.getCantidadGoles());
                System.out.println("numero de camiseta: "+ jugador.getNumeroCamiseta());
                System.out.println("Capitan: "+ jugador.getEsCapitan());

                if (cantidad != listaJugador.size()) {
                    System.out.println("-----------------------");
                }
                cantidad++;
            }
        }
    }


}
