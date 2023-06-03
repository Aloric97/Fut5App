package com.jedi.TP1.Controller;

import com.jedi.TP1.Services.EquipoService;
import com.jedi.TP1.Services.Imp.EquipoServiceImp;
import com.jedi.TP1.models.Equipo;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;


@Controller
public class EquipoController {

    private EquipoServiceImp equipoService;

    //instancio una nueva clase

    public EquipoController(){
        equipoService= new EquipoServiceImp();
    }

    public void agregarEquipo(String nombre, LocalDate fechaCreacion){
        Equipo equipo= new Equipo(nombre,fechaCreacion);
        equipoService.agregarEquipo(equipo);
    }

    public void listarEquipo(){
        equipoService.listarEquipos();
    }
}