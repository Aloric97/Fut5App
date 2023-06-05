package com.jedi.TP1.Controller;


import com.jedi.TP1.Services.Imp.EntrenadorServiceImp;
import com.jedi.TP1.models.Entrenador;
import org.springframework.stereotype.Controller;

@Controller
public class EntrenadorController {

    private final EntrenadorServiceImp entrenadorServiceImp;

    public EntrenadorController(){
        entrenadorServiceImp= new EntrenadorServiceImp();
    }

    public void agregarEntrenador(String nombre, String apellido, Integer edad){
        Entrenador entrenador= new Entrenador(nombre,apellido,edad);
        entrenadorServiceImp.agregarEntrenador(entrenador);
    }

    public void listarEntrenadores(){
        entrenadorServiceImp.listarEntrenadores();;
    }
}
