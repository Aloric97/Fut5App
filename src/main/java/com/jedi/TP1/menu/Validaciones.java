package com.jedi.TP1.menu;

import com.jedi.TP1.Controllers.JugadorController;
import com.jedi.TP1.models.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;


@Component
public class Validaciones {






    //Maneja el control de opciones, caso de que ingrese una entrada de datos que no sea entero,
    // le pedira que vuelva a ingresa la entrada de datos

    public static Integer validarOpcionEntero(Scanner scanner,String mensaje){
        int opcion;

        do {
            System.out.print(mensaje);

            while (!scanner.hasNextInt()) {
                System.out.println("El valor ingresado no es un número entero.");
                System.out.print("Ingrese un número entero: ");
                scanner.next(); // Descartar el valor no entero ingresado
            }

            opcion = scanner.nextInt();
        } while (opcion < 0); // Repetir hasta que se ingrese un valor no entero

        return opcion;
    }

    public static String obtenerStringNoNulo(Scanner scanner, String mensaje) {
        String entrada = null;

        while (entrada == null || entrada.trim().isEmpty()) {
            System.out.print(mensaje);
            entrada = scanner.nextLine();
        }

        return entrada;
    }
}
