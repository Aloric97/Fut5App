package com.jedi.TP1.Services.Imp;


import com.jedi.TP1.Services.EquipoService;
import com.jedi.TP1.models.Equipo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoServiceImp  implements EquipoService {

    private List<Equipo> listaEquipo= new ArrayList<>();

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
}

