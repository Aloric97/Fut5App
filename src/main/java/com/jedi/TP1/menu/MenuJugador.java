package com.jedi.TP1.menu;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class MenuJugador implements MenuOptionsHandler{

    @Autowired
    Generalidades generalidades;

    Scanner scanner= new Scanner(System.in);


    public void showMenuJugador(){
        int opcion;

        System.out.println("Bienvenidos a la gestion de equipos, por favor elija una opcion valida:\n");
        do {
            System.out.println("======================================");
            System.out.println("1-Crear Equipo");
            System.out.println("2-Modificar Equipo");
            System.out.println("3-Eliminar Equipo");
            System.out.println("4-Visualizar cantidad de equipos");
            System.out.println("5-Buscar un equipo");
            System.out.println("8-Volver al menu principal");
            System.out.println("9-Salir");
            System.out.println("======================================");
            opcion = generalidades.validarOpcionEntero();
            switch (opcion) {
                case 1 -> crear();
                case 2 -> modificar();
                case 3 -> eliminar();
                case 4 -> listar();
                case 5 -> buscar();
                case 8 -> System.out.println("implementacion a futuro");
                case 9 -> {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("Ha ingresado una opcion invalida");
            }
        } while (opcion!=9);
    }

    @Override
    public void crear() {
        int opcion;
        System.out.println("Ha elegido la opcion de crear jugador\n");
        System.out.println("Por Favor, ingrese el nombre del jugador");
        System.out.print("nombre:");
        String nombreJugador= scanner.nextLine();
        System.out.println("Eliga la posicion que va a jugar");
        System.out.println("1-ARQUERO 2-DEFENSOR 3-MEDIOCAMPISTA 4-DELANTERO");;
        String posicionJugador;
        opcion= generalidades.validarOpcionEntero();
        switch (opcion){
            case 1 -> posicionJugador="ARQUERO";
            case 2 -> posicionJugador="DEFENSOR";
            case 3 -> posicionJugador="MEDIOCAMPISTA";
            case 4 -> posicionJugador="DELANTERO";
        }
        System.out.println("ingrese la cantidad de goles que tiene:");
        int cantidadGoles = generalidades.validarOpcionEntero();
        System.out.println("es capitan?");
        System.out.println("opcion:");
        boolean esCapitan= scanner.nextBoolean();

        System.out.println("ingrese el numero de la camiseta:");
        int numeroCamiseta= scanner.nextInt();

        System.out.println("Quiere agregarlo a un equipo? 1-SI 2-NO");
        opcion=generalidades.validarOpcionEntero();
        if (opcion == 1) {
            asignarJugador();
        }

        System.out.println("jugador creado con exito");

    }

    @Override
    public void modificar() {

    }

    @Override
    public void eliminar() {

    }

    @Override
    public void listar() {

    }

    @Override
    public void buscar() {

    }

    @Override
    public void volverMenuPrincipal() {

    }

    @Override
    public void salir() {

    }

    private boolean asignarJugador(){}
}
