package com.jedi.TP1.Services;

import com.jedi.TP1.models.Equipo;

import java.util.List;
import java.util.Optional;


public interface EquipoService {


    void agregarEquipo(Equipo equipo);

    void listarEquipos();

    Optional<Equipo> buscarEquipo(String nombre);

    void listarEquipoCapitan(Equipo equipo);



}
