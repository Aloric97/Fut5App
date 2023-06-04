package com.jedi.TP1.menu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuEntrenador {

    @Autowired
    Generalidades generalidades;

    Scanner scanner= new Scanner(System.in);

    public void showMenuEntrenador(){
        int opcion;

        System.out.println("Bienvenidos a la gestion de entrenadores, por favor elija una opcion valida:\n");
        do {
            System.out.println("======================================");
            System.out.println("1-Crear Entrenador");
            System.out.println("2-Modificar Entrenador");
            System.out.println("3-Eliminar Entrenador");
            System.out.println("4-Visualizar cantidad de entrenadores");
            System.out.println("5-Buscar un entrenador");
            System.out.println("8-Volver al menu principal");
            System.out.println("9-Salir");
            System.out.println("======================================");
            opcion = generalidades.validarOpcionEntero();
            switch (opcion) {
                case 1 ->  System.out.println("por implementar");
                case 4 ->  System.out.println("por implementar 2");
                case 8 ->  System.out.println("por implementar 3");
                case 9 -> {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("Ha ingresado una opcion invalida");
            }
        } while (opcion!=9);
    }
}
