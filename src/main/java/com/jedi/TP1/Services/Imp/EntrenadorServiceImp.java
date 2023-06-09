package com.jedi.TP1.Services.Imp;


import com.jedi.TP1.Services.EntrenadorService;
import com.jedi.TP1.models.Entrenador;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorServiceImp implements EntrenadorService {

    private List<Entrenador> listaEntrenador= new ArrayList<>();
    @Override
    public Entrenador agregarEntrenador(String nombreEntrenador,String apellidoEntrenador,Integer edadEntrenador) {
        Entrenador entrenador= new Entrenador(nombreEntrenador,apellidoEntrenador,edadEntrenador);
        listaEntrenador.add(entrenador);
        return  entrenador;
    }

    @Override
    public void listarEntrenadores() {
        if (listaEntrenador.size() == 0) {
            System.out.println("no hay entreandores cargados");
        } else {
            int cantidad = 1;
            for (Entrenador entrenador : listaEntrenador) {
                System.out.println("entrenador: " + cantidad);
                System.out.println("nombre: " +entrenador.getNombre());
                System.out.println("apellido: " + entrenador.getApellido());
                System.out.println("altura: " + entrenador.getEdad());
                if (cantidad != listaEntrenador.size()) {
                    System.out.println("-----------------------");
                }
                cantidad++;
            }
        }
    }

    @Override
    public void eliminarEntrenador(String nombre) {
        Optional<Entrenador> findEntrenador= buscarEntrenador(nombre);
        if (findEntrenador.isPresent()){
            listaEntrenador.remove(findEntrenador.get());
            System.out.println("Entrenador eliminado...");
        } else {
            System.out.println("entrenador no existe");
        }
    }

    @Override
    public Optional<Entrenador> buscarEntrenador(String nombre) {
        return listaEntrenador.stream()
                .filter(entrenador -> entrenador.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

}
