package com.jedi.TP1.menu;

import com.jedi.TP1.Controllers.EquipoController;
import com.jedi.TP1.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;


@Component
public class MenuEquipo implements MenuOptionsHandler{


    //dependencias de inyecciones

    @Autowired
    Generalidades generalidades;

    @Autowired
    EquipoController equipoController;

    @Autowired
    MenuJugador menuJugador;

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
            System.out.println("4-Visualizar cantidad de equipos totales");
            System.out.println("5-Buscar un equipo");
            System.out.println("8-Volver al menu principal");
            System.out.println("9-Salir");
            System.out.println("======================================");
            opcion = generalidades.validarOpcionEntero();
            switch (opcion) {
                case 1 -> crear();
                case 4 -> listar();
                case 8 -> menuPrincipal.showMenuPrincipal();
                case 5 -> buscarEquipo();
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
                buscarJugador();
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
        System.out.println("Ha seleccionado la opcion listar equipos");
        System.out.println("los equipos creados son:");
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

    private void buscarEquipo(){

        System.out.println("Ha elegido la opcion de buscar un equipo");
        System.out.println("Ingrese el nombre del equipo a buscar:");
        String nombreEquipo= generalidades.controlVacio();
        Optional<Equipo> optionalEquipo=equipoController.buscarNombreEquipo(nombreEquipo);
        if (optionalEquipo.isPresent()){
            int opcion;

            do {
                System.out.println("Que quiere saber sobre este equipo?");
                System.out.println("1-nombre, nombre de entrenador y nombre del capitán del equipo");
                System.out.println("2-su nombre, nombre del entrenador y la lista de los jugadores del equipo");
                System.out.println("3-salir");
                opcion=generalidades.validarOpcionEntero();
                switch (opcion){
                    case 1 -> listarEquipoCapitan(optionalEquipo.get());
                    case 2 -> System.out.println(optionalEquipo.get());//listarEquipoJugadores();
                    case 3 -> showMenuEquipo();
                    default -> System.out.println("Ha elegido una opcion no valida");
                }
                opcion=generalidades.validarOpcionEntero();
            } while (opcion !=3);


        } else {
            System.out.println("equipo no encontrado");

        }
    }


    //private List<Equipo> listarEquipoJugadores(){}


    private void buscarJugador(){
        int opcion;
        do {
            System.out.println("Ha seleccionado la opcion agregar jugador");
            System.out.println("1-Crear nuevo jugador 2-Seleccionar uno ya existente 3-salir");

            opcion=generalidades.validarOpcionEntero();
            switch (opcion){
                case 1 -> System.out.println("proximamente");
                case 2 -> System.out.println("proximament2");
                case 3 -> showMenuEquipo();
                default -> System.out.println("Ha elegido una opcion no valida");
            }
        } while (opcion !=3);
    }

    private void listarEquipoCapitan(Equipo equipo){
        System.out.println("Ha seleccionado la primer opcion");
        System.out.println("El equipo es: ");
        System.out.println("=========================");
        equipoController.listarEquipoCapitan(equipo);
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }

}
