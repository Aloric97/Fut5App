package com.jedi.TP1.menu;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Scanner;


@Component
public class MenuPrincipal{






    //inyecciones de dependecias

    @Autowired
    MenuEquipo menuEquipo;

    @Autowired
    MenuEntrenador menuEntrenador;

    @Autowired
    MenuJugador menuJugador;



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
            System.out.println("======================================");
            opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
            switch (opcion) {
                case 1 -> menuEquipo.showMenuEquipo();
                case 2 -> menuJugador.showMenuJugador();
                case 3 -> menuEntrenador.showMenuEntrenador();
                case 9 -> {
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Ha ingresado una opcion invalida");
            }

        } while (opcion!=9);
    }
}
