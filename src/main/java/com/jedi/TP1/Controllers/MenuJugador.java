package com.jedi.TP1.Controllers;

import com.jedi.TP1.Services.Imp.EquipoServiceImp;
import com.jedi.TP1.Services.Imp.JugadorServiceImp;
import com.jedi.TP1.Validacion.Validaciones;
import com.jedi.TP1.enums.Posiciones;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class MenuJugador implements MenuOptionsHandler {


    Scanner scanner= new Scanner(System.in);

    @Autowired
    EquipoServiceImp equipoServiceImp;

    @Autowired
    JugadorServiceImp jugadorServiceImp;



    @Autowired
    @Lazy
    MenuPrincipal menuPrincipal;


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
            System.out.println("6-Importar archivo .txt con jugadores");
            System.out.println("8-Volver al menu principal");
            System.out.println("9-Salir");
            System.out.println("======================================");
            opcion = Validaciones.validarOpcionEntero(scanner,"Opcion:");
            switch (opcion) {
                case 1 -> crear();
                case 2 -> modificar();
                case 3 -> eliminar();
                case 4 -> listar();
                case 5 -> buscarJugador();
                case 6 -> importarArchivo();
                case 8 -> volverMenuPrincipal();
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

        scanner.nextLine();
        String nombreJugador= Validaciones.obtenerStringNoNulo(scanner, "Nombre del jugador:");

        System.out.println("Por Favor, ingrese el apellido del jugador");
        String apellidoJugador= Validaciones.obtenerStringNoNulo(scanner,"Apellido del jugador:");

        System.out.println("Elija la altura del jugador (acordarse que es decimal,por lo tanto termina con un .valor ; por ejemplo 0.12,1.0,):");
        System.out.print("altura:");
        Double alturaJugador= scanner.nextDouble();
        Posiciones posicion= asignarPosicion();
        System.out.println("ingrese la cantidad de goles que tiene:");
        int cantidadGoles = Validaciones.validarOpcionEntero(scanner,"Cantidad de goles:");
        System.out.println("es capitan? true-false");
        System.out.print("opcion:");
        boolean esCapitan= scanner.nextBoolean();

        System.out.println("ingrese el numero de la camiseta:");
        System.out.print("opcion:");
        int numeroCamiseta= scanner.nextInt();

        Jugador nuevoJugador=jugadorServiceImp.agregarJugador(nombreJugador,apellidoJugador,alturaJugador,posicion,cantidadGoles,esCapitan,numeroCamiseta);
        System.out.println("Quiere agregarlo a un equipo? 1-SI 2-NO");
        opcion=Validaciones.validarOpcionEntero(scanner, "Opcion:");
        if (opcion == 1) {
            asignarJugador(nuevoJugador);
        }

        System.out.println("jugador creado con exito");

    }

    public void crear(Equipo equipo) {

        System.out.println("Por Favor, ingrese el nombre del jugador");
        String nombreJugador= Validaciones.obtenerStringNoNulo(scanner,"Nombre del jugador:");

        System.out.println("Por Favor, ingrese el apellido del jugador");
        String apellidoJugador= Validaciones.obtenerStringNoNulo(scanner,"Apellido del jugador:");

        System.out.println("Elija la altura del jugador (acordarse que es decimal,por lo tanto termina con un .valor ; por ejemplo 0.12,1.0,):");
        System.out.print("altura:");
        Double alturaJugador= scanner.nextDouble();
        Posiciones posicion= asignarPosicion();
        System.out.println("ingrese la cantidad de goles que tiene:");
        int cantidadGoles = Validaciones.validarOpcionEntero(scanner,"Cantidad de goles:");
        System.out.println("es capitan? true-false");
        System.out.print("opcion:");
        boolean esCapitan= scanner.nextBoolean();

        System.out.println("ingrese el numero de la camiseta:");
        int numeroCamiseta= Validaciones.validarOpcionEntero(scanner,"Numero de camiseta:");

        Jugador nuevoJugador=jugadorServiceImp.agregarJugador(nombreJugador,apellidoJugador,alturaJugador,posicion,cantidadGoles,esCapitan,numeroCamiseta);
        equipo.getJugadores().add(nuevoJugador);

    }


    //ESTO DEBE ESTAR EN EL SERVICIO DE JUGADOR
    @Override
    public void modificar() {
        try {
            Jugador findJugador= buscarJugador();
            int opcion;

            do {
                System.out.println("Que atributo deseas modificar?");
                System.out.println("1-nombre 2-apellido 3-altura 4-posicion 5-cantidad de goles 6-capitan 7- numero de camiseta");
                opcion=Validaciones.validarOpcionEntero(scanner,"Opcion:");
                switch (opcion){
                    case 1-> {
                        System.out.println("ingrese un nuevo nombre:");
                        String nuevoNombre=Validaciones.obtenerStringNoNulo(scanner,"Nombre nuevo:");
                        findJugador.setNombre(nuevoNombre);
                    }
                    case 2-> {
                        System.out.println("ingrese un nuevo apellido:");
                        String nuevoApellido=Validaciones.obtenerStringNoNulo(scanner,"Apellido nuevo:");
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
                        int nuevoGoles= Validaciones.validarOpcionEntero(scanner, "goles:");
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
                        int nuevaCamiseta=Validaciones.validarOpcionEntero(scanner,"Nuevo numero de camiseta:");
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
        System.out.println("Ha elegido la opcion de eliminar juagdor");
        System.out.println("por favor, ingrese su nombre para buscarlo y eliminarlo");
        String nombreJugador =Validaciones.obtenerStringNoNulo(scanner,"nombre del jugador:");
        String apellidoJugador= Validaciones.obtenerStringNoNulo(scanner,"Apellido del jugador:");
        jugadorServiceImp.eliminarJugador(nombreJugador,apellidoJugador);
    }

    @Override
    public void listar() {
        System.out.println("los jugadores creados son:");
        System.out.println("=========================");
        jugadorServiceImp.listarJugador();
        System.out.println("=========================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
        showMenuJugador();

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

    public Jugador buscarJugador() {
        System.out.println("Ha elegido la opcion de buscar un jugador");
        System.out.println("Ingrese el nombre del jugador a buscar:");
        String nombreJugador= Validaciones.obtenerStringNoNulo(scanner,"Nombre del jugador:");
        System.out.println("ingrese el apellido del jugador a buscar:");
        String apellidoJugador= Validaciones.obtenerStringNoNulo(scanner,"Apellido del jugador:");
        Optional<Jugador> optionalJugador=jugadorServiceImp.buscarNombreApellidoJugador(nombreJugador,apellidoJugador);
        if (optionalJugador.isPresent()){
            return optionalJugador.get();
        }

        System.out.println("jugador no encontrado");
        return null;

    }

    private boolean asignarJugador(Jugador jugador){
        System.out.println("Ingrese el nombre del equipo a buscar:");
        String nombreEquipo= Validaciones.obtenerStringNoNulo(scanner,"Nombre del equipo:");
        Optional<Equipo> optionalEquipo=equipoServiceImp.buscarEquipo(nombreEquipo);
        if (optionalEquipo.isPresent()){
            equipoServiceImp.agregarJugadorAlEquipo(optionalEquipo.get(), jugador);
            System.out.println("El jugador ha sido agregado exitosamente al equipo");
            return true;
        }
        System.out.println("equipo no encontrado");
        System.out.println("Se procedera a crear solamente el jugador\n");

        return false;
    }

    private Posiciones asignarPosicion(){
        int opcion;
        Posiciones posicion= null;
        do{
            System.out.println("Eliga la posicion que va a jugar");
            System.out.println("1-ARQUERO 2-DEFENSOR 3-MEDIOCAMPISTA 4-DELANTERO");
            opcion= Validaciones.validarOpcionEntero(scanner,"Elegir posicion:");
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

    private void importarArchivo() {

        System.out.println("Ha seleccionado la opcion 'importar archivo' \n");
        jugadorServiceImp.visualizarArchivos();
        scanner.nextLine();
        String nombreArchivo = Validaciones.obtenerStringNoNulo(scanner, "Nombre del archivo:");
        System.out.println("Elija el equipo donde quiere agregar estos jugadores");
        String nombreEquipo = Validaciones.obtenerStringNoNulo(scanner, "Nombre del equipo:");

        jugadorServiceImp.importarJugadores(nombreArchivo,nombreEquipo);




    }
}