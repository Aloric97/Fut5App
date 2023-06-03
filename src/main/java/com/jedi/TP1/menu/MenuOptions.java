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
public class MenuOptions {


    @Autowired
    EquipoController equipoController;

    @Autowired
    JugadorController jugadorController;


    Scanner scanner= new Scanner(System.in);

    public void showMenu(){
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
            opcion=validarOpcionEntero();
            switch (opcion) {
                case 1 -> {
                    menuEquipo();
                    opcion = 9;
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

    private void menuEquipo(){
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
            opcion = validarOpcionEntero();

            switch (opcion) {
                case 1 -> {
                    crearEquipo();
                    opcion = 9;
                }
                case 4 -> listarEquipos();
                case 8 -> showMenu();
                case 9 -> {
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                }
                default -> System.out.println("Ha ingresado una opcion invalida");
            }
        } while (opcion!=9);

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

        System.out.println("Tiene algun jugador disponible para que agregar a su equipo? 1-SI 2-NO");
        opcion=validarOpcionEntero();
        while (opcion!=2){
            if (opcion == 1) {
                buscarJugador();
            }else{
                System.out.println("Ha ingresado una opcion invalida");
            }
            System.out.println("Tiene algun jugador disponible para agregar a su equipo? 1-SI 2-NO");
            opcion=validarOpcionEntero();
        }

        System.out.println("Tiene algun entrenador disponible para agregar a su equipo? 1-SI 2-NO");
        opcion=validarOpcionEntero();

        while (opcion!=2){
            if (opcion == 1) {
                buscarEntrenador();
            }{
                System.out.println("Ha ingresado una opcion invalida");
            }
            System.out.println("Tiene algun entrenador disponible para agregar a su equipo? 1-SI 2-NO");
            opcion=validarOpcionEntero();
        }

        System.out.println("\nDesea crear otro equipo? 1-SI 2-NO ");
        opcion=validarOpcionEntero();
        switch (opcion) {
            case 1 -> crearEquipo();
            case 2 -> {
                System.out.println("volviendo al menu de equipos...\n");
                menuEquipo();
            }
            default -> System.out.println("Ha ingresado una opcion invalida");
        }
    }

    //Maneja el control de opciones, caso de que ingrese una entrada de datos que no sea entero,
    // le pedira que vuelva a ingresa la entrada de datos
    private Integer validarOpcionEntero(){
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
        menuEquipo();
    }


    private void buscarJugador(){
        scanner.nextLine();
        System.out.print("Jugador:");
        String nombreJugador=scanner.nextLine();
        Optional<Jugador> optionalJugador= jugadorController.buscarJugadorNombre(nombreJugador);

        if (optionalJugador.isPresent()){
            Jugador jugador= optionalJugador.get();
        } else {
            System.out.println("jugador no encontrado");
        }

    }

    private void buscarEntrenador(){
        scanner.nextLine();
        System.out.print("Entrenador:");
        String nombreEntrenador=scanner.nextLine();


    }
}
