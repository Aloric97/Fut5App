package com.jedi.TP1.Controllers;


import com.jedi.TP1.Services.Imp.EntrenadorServiceImp;
import com.jedi.TP1.models.Entrenador;
import com.jedi.TP1.models.Equipo;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class EntrenadorController {

    private final EntrenadorServiceImp entrenadorServiceImp;

    public EntrenadorController(){
        entrenadorServiceImp= new EntrenadorServiceImp();
    }

    public Entrenador agregarEntrenador(String nombre, String apellido, Integer edad){
        Entrenador entrenador= new Entrenador(nombre,apellido,edad);
        entrenadorServiceImp.agregarEntrenador(entrenador);
        return entrenador;
    }

    public Optional<Entrenador> buscarNombreEntrenador(String nombre){
        return entrenadorServiceImp.buscarEntrenador(nombre);
    }


    public void listarEntrenadores(){
        entrenadorServiceImp.listarEntrenadores();
    }

    public void eliminarEntrenador(String nombre){
        entrenadorServiceImp.eliminarEntrenador(nombre);
    }
}
