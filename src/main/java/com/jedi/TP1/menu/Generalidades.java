package com.jedi.TP1.menu;

import com.jedi.TP1.Controller.JugadorController;
import com.jedi.TP1.models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;


@Component
public class Generalidades {


    @Autowired
    JugadorController jugadorController;
    Scanner scanner= new Scanner(System.in);



    //Maneja el control de opciones, caso de que ingrese una entrada de datos que no sea entero,
    // le pedira que vuelva a ingresa la entrada de datos

    public Integer validarOpcionEntero(){
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


    public void buscarJugador(){
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

    public void buscarEntrenador(){
        scanner.nextLine();
        System.out.print("Entrenador:");
        String nombreEntrenador=scanner.nextLine();


    }
}
