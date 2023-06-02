package com.jedi.TP1.menu;


import com.jedi.TP1.Controller.EquipoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;


@Component
public class MenuOptions {


    @Autowired
    EquipoController equipoController;

    Scanner scanner= new Scanner(System.in);

    public void showMenu(){
        Integer opcion;
        boolean validarEntrada=false;
        System.out.println(" ");
        System.out.println("Bienvenidos al menu de opciones, por favor elija una opcion valida:\n");
        do{
            System.out.println("======================================");
            System.out.println("1-Crear Equipo");
            System.out.println("2-Crear jugador");
            System.out.println("3-Crear entrenador");
            System.out.println("4-Lista Equipos");
            System.out.println("9-Salir");
            System.out.println("======================================");
            opcion=ValidarOpcionEntero();

            switch (opcion){
                case 1:
                    crearEquipo();
                    opcion=9;
                    break;
                case 4:
                    listarEquipos();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Ha ingresado una opcion invalida");
            }

        } while (opcion!=9);

    }

    private void elegirOpcion(Integer opcion){
        switch (opcion){
        case 1:
            System.out.println("volviendo al menu de inicio...\n");
            showMenu();
        case 2:
            System.out.println("Saliendo del programa...");
            break;
        default:
            System.out.println("Eliga una opcion valida");
        }
    }


    private void crearEquipo(){
        int opcion;
        System.out.println("Ha elegido la opcion de crear equipo\n");
        System.out.println("Por Favor, ingrese el nombre del equipo");
        scanner.nextLine();
        System.out.print("nombre:");
        String nombreEquipo= scanner.nextLine();
        LocalDate fechaHoy= LocalDate.now();

        equipoController.agregarEquipo(nombreEquipo,fechaHoy);

        System.out.println("Equipo creado con exito");
        System.out.println("\nDesea crear otro equipo? 1-SI 2-NO ");

        opcion=ValidarOpcionEntero();

        switch (opcion){
            case 1:
                crearEquipo();
                break;
            case 2:
                System.out.println("volviendo al menu de inicio...\n");
                showMenu();
        }


    }


    private Integer ValidarOpcionEntero(){
        int opcion;

        do {
            System.out.print("opcion:");

            while (!scanner.hasNextInt()) {
                System.out.println("El valor ingresado no es un número entero.");
                System.out.print("Ingrese un número entero: ");
                scanner.next(); // Descartar el valor no entero ingresado
            }

            opcion = scanner.nextInt();
        } while (opcion < 0); // Repetir hasta que se ingrese un valor no entero

    return opcion;
    }

    private void listarEquipos() {
        System.out.println("los equipos creados son:");
        System.out.println("=========================");
        equipoController.listarEquipo();
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
