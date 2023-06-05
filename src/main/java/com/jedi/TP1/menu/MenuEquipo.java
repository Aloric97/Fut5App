package com.jedi.TP1.menu;

import com.jedi.TP1.Controller.EquipoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;


@Component
public class MenuEquipo implements MenuOptionsHandler{


    //dependencias de inyecciones

    @Autowired
    Generalidades generalidades;

    @Autowired
    EquipoController equipoController;

    @Autowired
    @Lazy
    MenuPrincipal menuPrincipal;

    Scanner scanner= new Scanner(System.in);


    public void showMenuEquipo(){
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
                case 4 -> listar();
                case 8 -> menuPrincipal.showMenuPrincipal();
                case 9 -> {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("Ha ingresado una opcion invalida");
            }
        } while (opcion!=9);
    }





    public void modificarEquipo(){}

    @Override
    public void crear() {
        int opcion;

        System.out.println("***Ha elegido la opcion de crear equipo***\n");
        System.out.println("Por Favor, ingrese el nombre del equipo");
        System.out.print("nombre:");
        String nombreEquipo= scanner.nextLine();
        LocalDate fechaHoy= LocalDate.now();

        equipoController.agregarEquipo(nombreEquipo,fechaHoy);

        System.out.println("Tiene algun jugador disponible para que agregar a su equipo? 1-SI 2-NO");
        opcion=generalidades.validarOpcionEntero();
        while (opcion!=2){
            if (opcion == 1) {
                generalidades.buscarJugador();
            }else{
                System.out.println("Ha ingresado una opcion invalida");
            }
            System.out.println("Tiene algun jugador disponible para agregar a su equipo? 1-SI 2-NO");
            opcion=generalidades.validarOpcionEntero();
        }

        System.out.println("Tiene algun entrenador disponible para agregar a su equipo? 1-SI 2-NO");
        opcion=generalidades.validarOpcionEntero();

        while (opcion!=2){
            if (opcion == 1) {
                generalidades.buscarEntrenador();
            }{
                System.out.println("Ha ingresado una opcion invalida");
            }
            System.out.println("Tiene algun entrenador disponible para agregar a su equipo? 1-SI 2-NO");
            opcion=generalidades.validarOpcionEntero();
        }



        System.out.println("\nDesea crear otro equipo? 1-SI 2-NO ");
        opcion=generalidades.validarOpcionEntero();
        switch (opcion) {
            case 1 -> crear();
            case 2 -> {
                System.out.println("volviendo al menu de equipos...\n");
                showMenuEquipo();
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
        System.out.println("Ha seleccionado la opcion de listar equipos");


        System.out.println("=========================");
        equipoController.listarEquipo();
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();

        showMenuEquipo();
    }



    @Override
    public void volverMenuPrincipal() {

    }

    @Override
    public void salir() {

    }
}
