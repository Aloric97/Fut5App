package com.jedi.TP1.menu;

import com.jedi.TP1.Controllers.JugadorController;
import com.jedi.TP1.enums.Posiciones;
import com.jedi.TP1.models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;


@Component
public class MenuJugador implements MenuOptionsHandler{

    @Autowired
    Generalidades generalidades;

    Scanner scanner= new Scanner(System.in);

    @Autowired
    JugadorController jugadorController;


    public void showMenuJugador(){
        int opcion;

        System.out.println("Bienvenidos a la gestion de jugadores, por favor elija una opcion valida:\n");
        do {
            System.out.println("======================================");
            System.out.println("1-Crear jugador");
            System.out.println("2-Modificar jugador");
            System.out.println("3-Eliminar jugador");
            System.out.println("4-Visualizar cantidad de jugadores");
            System.out.println("5-Buscar un jugador");
            System.out.println("8-Volver al menu principal");
            System.out.println("9-Salir");
            System.out.println("======================================");
            opcion = generalidades.validarOpcionEntero();
            switch (opcion) {
                case 1 -> crear();
                case 2 -> modificar();
                case 3 -> eliminar();
                case 4 -> listar();
                case 5 -> buscarJugador();
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
        System.out.println("Ha seleccionado la opcion de crear un jugador");
        System.out.println("Por Favor, ingrese el nombre del jugador");

        String nombreJugador= generalidades.controlVacio();

        System.out.println("Por Favor, ingrese el apellido del jugador");
        String apellidoJugador= generalidades.controlVacio();

        System.out.println("Elija la altura del jugador (acordarse que es decimal,por lo tanto termina con un .valor ; por ejemplo 0.12,1.0,):");
        System.out.print("altura:");
        Double alturaJugador= scanner.nextDouble();
        Posiciones posicion= asignarPosicion();
        System.out.println("ingrese la cantidad de goles que tiene:");
        int cantidadGoles = generalidades.validarOpcionEntero();
        System.out.println("es capitan? true-false");
        System.out.print("opcion:");
        boolean esCapitan= scanner.nextBoolean();

        System.out.println("ingrese el numero de la camiseta:");
        System.out.print("opcion:");
        int numeroCamiseta= scanner.nextInt();

        jugadorController.agregarJugador(nombreJugador,apellidoJugador,alturaJugador,posicion,cantidadGoles,esCapitan,numeroCamiseta);
        System.out.println("Quiere agregarlo a un equipo? 1-SI 2-NO");
        opcion=generalidades.validarOpcionEntero();
        if (opcion == 1) {
            asignarJugador();
        }

        System.out.println("jugador creado con exito");

    }

    @Override
    public void modificar() {
        try {
            Jugador findJugador= buscarJugador();
            int opcion;

            do {
                System.out.println("Que atributo deseas modificar?");
                System.out.println("1-nombre 2-apellido 3-altura 4-posicion 5-cantidad de goles 6-capitan 7- numero de camiseta");
                opcion=generalidades.validarOpcionEntero();
                switch (opcion){
                    case 1-> {
                        System.out.println("ingrese un nuevo nombre:");
                        System.out.print("nombre:");
                        String nuevoNombre=generalidades.controlVacio();
                        findJugador.setNombre(nuevoNombre);
                    }
                    case 2-> {
                        System.out.println("ingrese un nuevo apellido:");
                        System.out.print("apellido:");
                        String nuevoApellido=generalidades.controlVacio();
                        findJugador.setApellido(nuevoApellido);
                    }
                    case 3->{
                        System.out.println("ingrese un nueva altura:");
                        System.out.print("altura:");
                        Double nuevaAltura=scanner.nextDouble();
                        findJugador.setAltura(nuevaAltura);
                    }
                    case 4->{
                        System.out.println("ingrese un nueva posicion:");
                        System.out.print("altura:");
                        Posiciones nuevaPosicion= asignarPosicion();
                        findJugador.setPosiciones(nuevaPosicion);
                    }
                    case 5->{
                        System.out.println("ingrese una nueva cantidad de goles:");
                        System.out.print("goles:");
                        int nuevoGoles= scanner.nextInt();
                        findJugador.setCantidadGoles(nuevoGoles);
                    }
                    case 6 ->{
                        System.out.println("quiere ser capitan? true-false:");
                        System.out.print("capitan:");
                        boolean nuevoCapitan= scanner.nextBoolean();
                        findJugador.setEsCapitan(nuevoCapitan);
                    }
                    case 7 ->{
                        System.out.println("ingrese un nuevo numero de camiseta?");
                        System.out.print("numero de camiseta:");
                        int nuevaCamiseta=scanner.nextInt();
                        findJugador.setNumeroCamiseta(nuevaCamiseta);
                    }
                    default -> System.out.println("ingreso una opcion invalidad");
                }
            } while (opcion>7);

            System.out.println("Atributo del jugador modificado con exito");

        } catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }



    }

    @Override
    public void eliminar() {

    }

    @Override
    public void listar() {
        System.out.println("los jugadores creados son:");
        System.out.println("=========================");
        jugadorController.listarJugador();
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        showMenuJugador();

    }



    @Override
    public void volverMenuPrincipal() {

    }

    @Override
    public void salir() {

    }

    private Jugador buscarJugador() {
        System.out.println("Ha elegido la opcion de buscar un jugador");
        System.out.println("Ingrese el nombre del jugador a buscar:");
        String nombreJugador= generalidades.controlVacio();
        System.out.println("ingrese el apellido del jugador a buscar:");
        String apellidoJugador= generalidades.controlVacio();
        Optional<Jugador> optionalJugador=jugadorController.buscarNombreApellidoJugador(nombreJugador,apellidoJugador);
        if (optionalJugador.isPresent()){
            return optionalJugador.get();
        }

        System.out.println("jugador no encontrado");
        return null;

    }

    private boolean asignarJugador(){
        return false;
    }

    private Posiciones asignarPosicion(){
        int opcion;
        Posiciones posicion= null;
        do{
            System.out.println("Eliga la posicion que va a jugar");
            System.out.println("1-ARQUERO 2-DEFENSOR 3-MEDIOCAMPISTA 4-DELANTERO");
            opcion= generalidades.validarOpcionEntero();
            switch (opcion){
                case 1 -> {
                    return posicion=Posiciones.ARQUERO;
                }
                case 2 -> {
                    return posicion=Posiciones.DEFENSOR;
                }
                case 3 -> {
                    return posicion=Posiciones.MEDIOCAMPISTA;
                }
                case 4 -> {
                    return posicion=Posiciones.DELANTERO;
                }
                default -> System.out.println("ha elegido una opcion no valida\n");
            }
        } while(opcion>4);

        return null;
    }



}
