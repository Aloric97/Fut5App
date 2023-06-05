package com.jedi.TP1.Services.Imp;


import com.jedi.TP1.Services.EquipoService;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImp  implements EquipoService {

    private final List<Equipo> listaEquipo= new ArrayList<>();

    @Override
    public void agregarEquipo(Equipo equipo) {
        //comprobar si es el unico en la lista
        if (listaEquipo.stream().anyMatch(equipo1 -> equipo1.getNombre().equalsIgnoreCase(equipo.getNombre()))) {
            System.out.println("Este equipo ya se encuentra en la lista");
        } else {
            listaEquipo.add(equipo);
            System.out.println("Equipo creado con exito");
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
            System.out.println("nombre del entrenador:"+ equipo.getEntrenador());
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
}

