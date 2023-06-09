package com.jedi.TP1.Services.Imp;


import com.jedi.TP1.Services.EquipoService;
import com.jedi.TP1.models.Entrenador;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImp  implements EquipoService {

    private final List<Equipo> listaEquipo= new ArrayList<>();

    @Override
    public Equipo agregarEquipo(String nombreEquipo, LocalDate fechaHoy) {
        //comprobar si es el unico en la lista
        if (listaEquipo.stream().anyMatch(equipo -> equipo.getNombre().equalsIgnoreCase(nombreEquipo))) {
            System.out.println("Este equipo ya se encuentra en la lista");
            return null;
        } else {
            Equipo equipo= new Equipo(nombreEquipo,fechaHoy);
            listaEquipo.add(equipo);
            System.out.println("Equipo creado con exito");
            return equipo;
        }
    }

    @Override
    public void listarEquipos() {
        if (listaEquipo.size() == 0) {
            System.out.println("no hay equipos cargados");
        } else {
            int cantidad = 1;
            for (Equipo equipo : listaEquipo) {
                System.out.println("Equipo: " + cantidad);
                System.out.println("nombre: " + equipo.getNombre());
                System.out.println("fecha de creacion: " + equipo.getFechaCreacion());
                if (equipo.getJugadores().isEmpty()) {
                    System.out.println("No hay jugadores");
                }else {
                    System.out.println("jugadores:");
                    for (Jugador jugador:equipo.getJugadores()) {
                        System.out.println("    nombre:"+ jugador.getNombre());
                        System.out.println("    posicion:"+ jugador.getPosiciones());
                        System.out.println("    -----------------");
                    }
                }
                if (equipo.getEntrenador()==null){
                    System.out.println("no hay entrenador");
                }else {
                    System.out.println("entrandor:"+equipo.getEntrenador().getNombre());
                }
                if (cantidad != listaEquipo.size()) {
                    System.out.println("-----------------------");
                }
                cantidad++;
            }
        }

    }

    @Override
    public Optional<Equipo> buscarEquipo(String nombre) {
        return listaEquipo.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    @Override
    public void listarEquipoCapitan(Equipo equipo) {
        System.out.println("nombre del equipo:"+ equipo.getNombre());
        if (equipo.getEntrenador() != null) {
            System.out.println("nombre del entrenador:"+ equipo.getEntrenador().getNombre());
        } else {
            System.out.println("No tiene entrenador");
        }
        if (equipo.getJugadores()==null){
            System.out.println("no tiene jugadores");
        }else{
            Optional<Jugador> findJugadorCapitan= equipo.getJugadores()
                    .stream().filter(Jugador::getEsCapitan)
                    .findFirst();
            if (findJugadorCapitan.isPresent()){
                System.out.println("nombre del capitan:"+ findJugadorCapitan.get().getNombre());
            } else {
                System.out.println("No tiene capitan");
            }
        }
    }

    @Override
    public void listarEquipoCompleto(Equipo equipo) {
        System.out.println("nombre: " + equipo.getNombre());
        System.out.println("fecha de creacion: " + equipo.getFechaCreacion());
        if (equipo.getJugadores().isEmpty()) {
            System.out.println("No hay jugadores");
        }else {
            System.out.println("jugadores:");
            int cantidad=1;
            for (Jugador jugador:equipo.getJugadores()) {
                System.out.println("    Jugador nro:" + cantidad);
                System.out.println("    nombre:"+ jugador.getNombre());
                System.out.println("    apellido:"+jugador.getApellido());
                System.out.println("    posicion:"+ jugador.getPosiciones());
                System.out.println("    altura:"+ jugador.getAltura() +" mts");
                System.out.println("    cantidad de goles:"+ jugador.getCantidadGoles());
                System.out.println("    capitan:"+ jugador.getEsCapitan());
                System.out.println("    numero de camiseta:"+ jugador.getNumeroCamiseta());
                System.out.println("    ----------------------");
                cantidad++;
            }
        }
        if (equipo.getEntrenador()==null){
            System.out.println("no hay entrenador");
        }else {
            System.out.println("entrenador:"+equipo.getEntrenador().getNombre());
        }
    }


    @Override
    public void agregarJugadorAlEquipo(Equipo equipo,Jugador jugador) {

        if (jugador.getEquipo() != null) {
            System.out.println("El jugador ya tiene equipo");
            System.out.println("se procedera solamente a crear el jugador");
        } else if(jugador.getEsCapitan()) {
            Optional<Jugador> jugadorCapitan=equipo.getJugadores().stream().filter(Jugador::getEsCapitan).findFirst();
            if (jugadorCapitan.isPresent()) {
                System.out.println("El equipo ya tiene un capitan");
                System.out.println("se procedera solamente a crear el jugador");
            } else {
                equipo.getJugadores().add(jugador);
            }
        } else {
            equipo.getJugadores().add(jugador);
        }
    }

    @Override
    public void agregarEntrenadorEquipo(Equipo equipo, Entrenador entrenador) {
        if (entrenador.getEquipo() != null) {
            System.out.println("El entrenador ya tiene equipo");
        } else {
            equipo.setEntrenador(entrenador);
        }
    }

    @Override
    public void eliminarEquipo(String nombre) {
        Optional<Equipo> findEquipo= buscarEquipo(nombre);
        if (findEquipo.isPresent()){
            listaEquipo.remove(findEquipo.get());
            System.out.println("equipo eliminado...");
        } else {
            System.out.println("equipo no existe");
        }
    }

    @Override
    public void ordenarPorNombreJugadores( String nombre) {
        Optional<Equipo> optionalEquipo= buscarEquipo(nombre);
        if (optionalEquipo.isPresent()) {
            Equipo equipo = optionalEquipo.get();
            equipo.getJugadores().sort(Comparator.comparing(Jugador::getNombre));
            listarEquipoCompleto(equipo);


        }else {
            System.out.println("no existe el equipo");
        }

    }

}

