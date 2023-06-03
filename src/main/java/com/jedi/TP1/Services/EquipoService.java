package com.jedi.TP1.Services;

import com.jedi.TP1.models.Equipo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface EquipoService {


    void agregarEquipo(Equipo equipo);

    void listarEquipos();

}
