package com.jedi.TP1.Controllers;


import com.jedi.TP1.Services.Imp.EquipoServiceImp;

import com.jedi.TP1.Validacion.Validaciones;
import com.jedi.TP1.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

@Component
public class MenuEquipo implements MenuOptionsHandler {
    //dependencias de inyecciones

    @Autowired
    EquipoServiceImp equipoServiceImp;

    @Autowired
    MenuJugador menuJugador;

    @Autowired
    MenuEntrenador menuEntrenador;

    @Autowired
    @Lazy
    MenuPrincipal menuPrincipal;

    Scanner scanner= new Scanner(System.in);


    public void showMenuEquipo(){
        int opcion;

        System.out.println("\n Bienvenidos a la gestion de equipos, por favor elija una opcion valida:");
        do {
            System.out.println("======================================");
            System.out.println("1-Crear Equipo");
            System.out.println("2-Eliminar Equipo");
            System.out.println("4-Visualizar cantidad de equipos totales");
            System.out.println("5-Buscar un equipo");
            System.out.println("6-exportar jugadores de un equipo extension .txt");
            System.out.println("8-Volver al menu principal");
            System.out.println("9-Salir");
            System.out.println("======================================");
            opcion = Validaciones.validarOpcionEntero(scanner,"Opcion:");
            switch (opcion) {
                case 1 -> crear();
                case 2 -> eliminar();
                case 4 -> listar();
                case 5 -> buscarEquipo();
                case 6 -> exportarJugadores();
                case 8 -> menuPrincipal.showMenuPrincipal();
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

        System.out.println("***Ha elegido la opcion de crear equipo***\n");
        System.out.println("Por Favor, ingrese el nombre del equipo");
        String nombreEquipo= Validaciones.obtenerStringNoNulo(scanner,"Nombre del equipo:");
        LocalDate fechaHoy= LocalDate.now();

        Equipo nuevoEquipo=equipoServiceImp.agregarEquipo(nombreEquipo,fechaHoy);

        System.out.println("crear un jugador para que agregar a su equipo? 1-SI 2-NO");
        opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
        while (opcion!=2){
            if (opcion == 1) {
                buscarJugador(nuevoEquipo);
                break;
            }else{
                System.out.println("Ha ingresado una opcion invalida");
            }
            System.out.println("crear un jugador para agregar a su equipo? 1-SI 2-NO");
            opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
        }

        System.out.println("crear un entrenador  para agregar a su equipo? 1-SI 2-NO");
        opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");

        while (opcion!=2){
            if (opcion == 1) {
                buscarEntrenador(nuevoEquipo);
                break;
            }{
                System.out.println("Ha ingresado una opcion invalida");
            }
            System.out.println("crear un entrenador para agregar a su equipo? 1-SI 2-NO");
            opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
        }

        System.out.println("\nDesea crear otro equipo? 1-SI 2-NO ");
        opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
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
        System.out.println("Funcionalidad a futuro");
    }

    @Override
    public void eliminar() {
        System.out.println("Ha elegido la opcion de eliminar un equipo");
        System.out.println("por favor, ingrese su nombre para buscarlo y eliminarlo");
        String nombreEquipo =Validaciones.obtenerStringNoNulo(scanner,"nombre del equipo:");
        equipoServiceImp.eliminarEquipo(nombreEquipo);
    }

    @Override
    public void listar() {
        System.out.println("Ha seleccionado la opcion listar equipos");
        System.out.println("los equipos creados son:");
        System.out.println("=========================");
        equipoServiceImp.listarEquipos();
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();

        showMenuEquipo();
    }



    @Override
    public void volverMenuPrincipal() {
        menuPrincipal.showMenuPrincipal();
    }

    @Override
    public void salir() {
        scanner.close();
        System.exit(0);
    }

    private void buscarEquipo(){

        System.out.println("Ha elegido la opcion de buscar un equipo");
        System.out.println("Ingrese el nombre del equipo a buscar:");
        scanner.nextLine();
        String nombreEquipo= Validaciones.obtenerStringNoNulo(scanner, "nombre del equipo:");
        Optional<Equipo> optionalEquipo=equipoServiceImp.buscarEquipo(nombreEquipo);
        if (optionalEquipo.isPresent()){
            int opcion;
            do {
                System.out.println("Que quiere saber sobre este equipo?");
                System.out.println("1-nombre, nombre de entrenador y nombre del capitán del equipo");
                System.out.println("2-su nombre, nombre del entrenador y la lista de los jugadores del equipo");
                System.out.println("3-salir");
                opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
                switch (opcion){
                    case 1 -> listarEquipoCapitan(optionalEquipo.get());
                    case 2 -> listarEquipoCompleto(optionalEquipo.get());
                    case 3 -> showMenuEquipo();
                    default -> System.out.println("Ha elegido una opcion no valida");
                }
                opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
            } while (opcion !=3);


        } else {
            scanner.nextLine();
            System.out.println("\nequipo no encontrado");

        }
    }


    private void listarEquipoCompleto(Equipo equipo){
        System.out.println("Ha seleccionado la opcion de listar el equipo con todos los jugadores");
        equipoServiceImp.listarEquipoCompleto(equipo);
        System.out.println("****************************************");
        int opcion;
        do {
            System.out.println("\n1-lista de los jugadores del equipo ordenados por su nombre.");
            System.out.println("2-lista de los jugadores del equipo ordenados por número de camiseta.");
            System.out.println("3-lista de los jugadores del equipo ordenados por su posición y número de camiseta.");
            System.out.println("4-salir\n");
            opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
            switch (opcion){
                case 1 -> ordenarPorNombreJugadores(equipo);
                case 2 -> ordenarPorCamiseta(equipo);
                case 3 -> ordenarPorPosicionCamiseta(equipo);
                case 4 -> showMenuEquipo();
                default -> System.out.println("Ha elegido una opcion no valida");
            }
        } while (opcion !=4);




        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        showMenuEquipo();
    }


    private void buscarJugador(Equipo equipo){
        System.out.println("Ha seleccionado la opcion agregar jugador");
        menuJugador.crear(equipo);


    }

    private void listarEquipoCapitan(Equipo equipo){
        System.out.println("Ha seleccionado la primer opcion");
        System.out.println("El equipo es: ");
        System.out.println("=========================");
        equipoServiceImp.listarEquipoCapitan(equipo);
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        showMenuEquipo();
    }


    private void buscarEntrenador(Equipo equipo){
        System.out.println("Ha seleccionado la opcion agregar entrenador");
        menuEntrenador.crear(equipo);
    }

    private void exportarJugadores() {
        System.out.println("Ha seleccionado la opcion exportar jugadores\n");

        System.out.println("por favor, ingrese el nombre del equipo:");
        String nombreEquipo= Validaciones.obtenerStringNoNulo(scanner,"nombre del equipo:");

        Optional<Equipo> findEquipo= equipoServiceImp.buscarEquipo(nombreEquipo);

        if (findEquipo.isPresent()) {
            equipoServiceImp.exportarEquipo(findEquipo.get());
        }else {
            System.out.println("Jugador no encontrado");
        }

        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        showMenuEquipo();

    }

    private void exportarJugadores(String nombreEquipo){
        Optional<Equipo> findEquipo= equipoServiceImp.buscarEquipo(nombreEquipo);

        if (findEquipo.isPresent()) {
            equipoServiceImp.exportarEquipo(findEquipo.get());
        }else {
            System.out.println("Jugador no encontrado");
        }

        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        showMenuEquipo();
    }


    private void ordenarPorNombreJugadores(Equipo equipo){
        equipoServiceImp.ordenarPorNombreJugadores(equipo.getNombre());

        System.out.println("Desea exportar este archivo ordenado? 1-SI 2-NO");        int opcion=Validaciones.validarOpcionEntero(scanner,"opcion:");

        switch (opcion) {
            case 1 -> exportarJugadores(equipo.getNombre());
            case 2 -> {
                System.out.println("volviendo al menu de equipos...\n");
                showMenuEquipo();
            }
            default -> System.out.println("Ha ingresado una opcion invalida");
        }
    }

    private void ordenarPorCamiseta(Equipo equipo){

        equipoServiceImp.ordenarPorCamiseta(equipo.getNombre());

        System.out.println("Desea exportar este archivo ordenado? 1-SI 2-NO");
        int opcion=Validaciones.validarOpcionEntero(scanner,"opcion:");
        switch (opcion) {
            case 1 -> exportarJugadores(equipo.getNombre());
            case 2 -> {
                System.out.println("volviendo al menu de equipos...\n");
                showMenuEquipo();
            }
            default -> System.out.println("Ha ingresado una opcion invalida");
        }

    }

    private void ordenarPorPosicionCamiseta(Equipo equipo){

        equipoServiceImp.ordenarPorPosicionCamiseta(equipo.getNombre());

        System.out.println("Desea exportar este archivo ordenado? 1-SI 2-NO");

        int opcion=Validaciones.validarOpcionEntero(scanner,"opcion:");
        switch (opcion) {
            case 1 -> exportarJugadores(equipo.getNombre());
            case 2 -> {
                System.out.println("volviendo al menu de equipos...\n");
                showMenuEquipo();
            }
            default -> System.out.println("Ha ingresado una opcion invalida");
        }

    }

}