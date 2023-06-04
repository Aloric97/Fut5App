package com.jedi.TP1.menu;


import com.jedi.TP1.Controller.EquipoController;
import com.jedi.TP1.Controller.JugadorController;
import com.jedi.TP1.models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;


@Component
public class MenuPrincipal{



    @Autowired
    Generalidades generalidades;




    @Autowired
    MenuEquipo menuEquipo;

    @Autowired
    MenuEntrenador menuEntrenador;

    Scanner scanner= new Scanner(System.in);

    public void showMenuPrincipal(){
        Integer opcion;
        System.out.println(" ");
        System.out.println("Bienvenidos al menu de opciones, por favor elija una opcion valida:\n");
        do{
            System.out.println("======================================");
            System.out.println("1-Gestion de Equipo");
            System.out.println("2-Gestion de Jugador");
            System.out.println("3-Gestion de Entrenador");
            System.out.println("9-Salir");
            System.out.println("===================================2===");
            opcion=generalidades.validarOpcionEntero();
            switch (opcion) {
                case 1 -> {
                    menuEquipo.showMenuEquipo();
                    System.exit(0);
                }
                case 2 ->{
                    menuEntrenador.showMenuEntrenador();
                    System.exit(0);
                }
                case 9 -> {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("Ha ingresado una opcion invalida");
            }

        } while (opcion!=9);
        scanner.close();
    }
}
