package com.jedi.TP1.menu;


import com.jedi.TP1.Controller.EntrenadorController;
import com.jedi.TP1.enums.Posiciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class MenuEntrenador  implements  MenuOptionsHandler{

    @Autowired
    Generalidades generalidades;

    @Autowired
    EntrenadorController entrenadorController;

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
                case 1 ->  crear();
                case 4 ->  listar();
                case 8 ->  System.out.println("por implementar 3");
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
        System.out.println("***Ha elegido la opcion de crear entrenador***\n");

        System.out.println("Por Favor, ingrese el nombre del entrenador");
        String nombreEntrenador= generalidades.controlVacio();

        System.out.println("Por Favor, ingrese el apellido del jugador");
        String apellidoEntrenador= generalidades.controlVacio();



        System.out.println("ingrese la edad del entrenador");
        int edadEntrenador = generalidades.validarOpcionEntero();

        entrenadorController.agregarEntrenador(nombreEntrenador,apellidoEntrenador,edadEntrenador);

        System.out.println("Quiere agregarlo a un equipo? 1-SI 2-NO");
        opcion=generalidades.validarOpcionEntero();
        if (opcion == 1) {
            asignarEntrenador();
        }

        System.out.println("jugador creado con exito");


        System.out.println("\nDesea crear otro entrenador? 1-SI 2-NO ");
        opcion=generalidades.validarOpcionEntero();
        switch (opcion) {
            case 1 -> crear();
            case 2 -> {
                System.out.println("volviendo al menu de equipos...\n");
                showMenuEntrenador();
            }
            default -> System.out.println("Ha ingresado una opcion invalida");
        }
    }

    @Override
    public void modificar() {

    }

    @Override
    public void eliminar() {

    }

    @Override
    public void listar() {
        System.out.println("los entrenadores creados son:");
        System.out.println("=========================");
        entrenadorController.listarEntrenadores();
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        showMenuEntrenador();
    }

    @Override
    public void volverMenuPrincipal() {

    }

    @Override
    public void salir() {

    }

    private void asignarEntrenador(){

    }
}
