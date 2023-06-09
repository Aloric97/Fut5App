package com.jedi.TP1.Controllers;

import com.jedi.TP1.Services.Imp.EntrenadorServiceImp;
import com.jedi.TP1.Services.Imp.EquipoServiceImp;

import com.jedi.TP1.Validacion.Validaciones;
import com.jedi.TP1.models.Entrenador;
import com.jedi.TP1.models.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class MenuEntrenador  implements MenuOptionsHandler {



    @Autowired
    EntrenadorServiceImp entrenadorServiceImp;

    @Autowired
    EquipoServiceImp equipoServiceImp;

    @Autowired
    @Lazy
    MenuPrincipal menuPrincipal;

    Scanner scanner= new Scanner(System.in);

    public void showMenuEntrenador(){
        int opcion;

        System.out.println("Bienvenidos a la gestion de entrenadores, por favor elija una opcion valida:\n");
        do {
            System.out.println("======================================");
            System.out.println("1-Crear Entrenador");
            System.out.println("3-Eliminar Entrenador");
            System.out.println("4-Visualizar cantidad de entrenadores");
            System.out.println("5-Buscar un entrenador");
            System.out.println("8-Volver al menu principal");
            System.out.println("9-Salir");
            System.out.println("======================================");
            opcion = Validaciones.validarOpcionEntero(scanner, "opcion:");
            switch (opcion) {
                case 1 ->  crear();
                case 3 -> eliminar();
                case 4 ->  listar();
                case 5 -> buscarEntrenador();
                case 8 ->  volverMenuPrincipal();
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
        String nombreEntrenador= Validaciones.obtenerStringNoNulo(scanner,"nombre del entrenador:");

        System.out.println("Por Favor, ingrese el apellido del jugador");
        String apellidoEntrenador= Validaciones.obtenerStringNoNulo(scanner,"apellido del entrenador:");



        System.out.println("ingrese la edad del entrenador");
        int edadEntrenador = Validaciones.validarOpcionEntero(scanner, "edad del entrenador:");

        Entrenador nuevoEntrenador= entrenadorServiceImp.agregarEntrenador(nombreEntrenador,apellidoEntrenador,edadEntrenador);

        System.out.println("Quiere agregarlo a un equipo? 1-SI 2-NO");
        opcion=Validaciones.validarOpcionEntero(scanner, "opcion:");
        if (opcion == 1) {
            asignarEntrenador(nuevoEntrenador);
        }

        System.out.println("jugador creado con exito");


        System.out.println("\nDesea crear otro entrenador? 1-SI 2-NO ");
        opcion=Validaciones.validarOpcionEntero(scanner, "opcion:");
        switch (opcion) {
            case 1 -> crear();
            case 2 -> {
                System.out.println("volviendo al menu de equipos...\n");
                showMenuEntrenador();
            }
            default -> System.out.println("Ha ingresado una opcion invalida");
        }
    }

    public void crear(Equipo equipo) {
        int opcion;

        System.out.println("Por Favor, ingrese el nombre del entrenador");
        String nombreEntrenador= Validaciones.obtenerStringNoNulo(scanner,"nombre del entrenador:");

        System.out.println("Por Favor, ingrese el apellido del jugador");
        String apellidoEntrenador= Validaciones.obtenerStringNoNulo(scanner,"apellido del entrenador:");


        System.out.println("ingrese la edad del entrenador");
        int edadEntrenador = Validaciones.validarOpcionEntero(scanner,"Edad del entrenador:");

        Entrenador nuevoEntrenador= entrenadorServiceImp.agregarEntrenador(nombreEntrenador,apellidoEntrenador,edadEntrenador);
        equipo.setEntrenador(nuevoEntrenador);

        System.out.println("entrenador creado y unido al equipo con exito");


    }

    @Override
    public void modificar() {
        System.out.println("funcion sera agregada a futuro");
    }

    @Override
    public void eliminar() {
        System.out.println("Ha elegido la opcion de eliminar un entrenado");
        System.out.println("por favor, ingrese su nombre para buscarlo y eliminarlo");
        String nombreEntrenador =Validaciones.obtenerStringNoNulo(scanner,"Nombre del entrenador:");
        entrenadorServiceImp.eliminarEntrenador(nombreEntrenador);
    }

    @Override
    public void listar() {
        System.out.println("los entrenadores creados son:");
        System.out.println("=========================");
        entrenadorServiceImp.listarEntrenadores();
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        showMenuEntrenador();
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

    public Entrenador buscarEntrenador(){
        System.out.println("Ingrese el nombre del entrenador a buscar:");
        String nombreEntrenador= Validaciones.obtenerStringNoNulo(scanner,"Nombre del entrenador:");

        Optional<Entrenador> optionalEntrenador=entrenadorServiceImp.buscarEntrenador(nombreEntrenador);
        if (optionalEntrenador.isPresent()){
            System.out.println("entrenador encontrado");
            System.out.println("nombre: " + optionalEntrenador.get().getNombre());
            System.out.println("apellido: "+optionalEntrenador.get().getApellido());
            return optionalEntrenador.get();
        }

        System.out.println("jugador no encontrado");
        return null;
    }

    private void asignarEntrenador(Entrenador entrenador){
        System.out.println("Ha seleccionado la opcion de agregarlo a un equipo");
        System.out.println("Ingrese el nombre del equipo a buscar:");
        String nombreEquipo= Validaciones.obtenerStringNoNulo(scanner,"Nombre del equipo:");
        Optional<Equipo> optionalEquipo=equipoServiceImp.buscarEquipo(nombreEquipo);
        if (optionalEquipo.isPresent()){
            equipoServiceImp.agregarEntrenadorEquipo(optionalEquipo.get(), entrenador);

        } else {
            System.out.println("equipo no encontrado");
            System.out.println("Se procedera a crear solamente el entrenador\n");
        }

    }
}
