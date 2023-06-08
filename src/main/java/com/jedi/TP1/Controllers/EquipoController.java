package com.jedi.TP1.Controllers;

import com.jedi.TP1.Services.Imp.EquipoServiceImp;
import com.jedi.TP1.models.Entrenador;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Optional;


@Controller
public class EquipoController {

    private final EquipoServiceImp equipoServiceImp;

    //instancio una nueva clase

    public EquipoController(){
        equipoServiceImp= new EquipoServiceImp();
    }

    public Equipo agregarEquipo(String nombre, LocalDate fechaCreacion){
        Equipo equipo= new Equipo(nombre,fechaCreacion);
        equipoServiceImp.agregarEquipo(equipo);
        return equipo;
    }

    public void listarEquipo(){
        equipoServiceImp.listarEquipos();
    }

    public Optional<Equipo> buscarNombreEquipo(String nombre){
        return equipoServiceImp.buscarEquipo(nombre);
    }

    public void listarEquipoCapitan(Equipo equipo){
        equipoServiceImp.listarEquipoCapitan(equipo);
    }

    public void agregarJugadorAlEquipo(Equipo equipo,Jugador jugador){
        equipoServiceImp.agregarJugadorAlEquipo(equipo,jugador);

    }

    public void listarEquipoCompleto(Equipo equipo){
        equipoServiceImp.listarEquipoCompleto(equipo);
    }

    public void agregarEntrenadorEquipo(Equipo equipo, Entrenador entrenador){
        equipoServiceImp.agregarEntrenadorEquipo(equipo, entrenador);
    }

}
