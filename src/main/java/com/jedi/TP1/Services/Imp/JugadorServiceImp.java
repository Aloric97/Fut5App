package com.jedi.TP1.Services.Imp;

import com.jedi.TP1.Services.JugadorService;
import com.jedi.TP1.enums.Posiciones;
import com.jedi.TP1.models.Equipo;
import com.jedi.TP1.models.Jugador;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImp implements JugadorService {


    @Autowired
    EquipoServiceImp equipoServiceImp;

    private final List<Jugador> listaJugador= new ArrayList<>();


    //voy a usar funciones lambdas para tratar las busquedas
    @Override
    public Optional<Jugador> buscarNombreApellidoJugador(String nombre, String apellido) {

        return listaJugador.stream()
                .filter(jugador -> jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido))
                .findFirst();
    }

    @Override
    public void importarJugadores( String nombreArchivo,String equipo) {
        //para obtener la ruta central
        String rutaProyecto = System.getProperty("user.dir");
        String rutaCarpeta = rutaProyecto + "/src/main/resources/Entrada";


        Path obtenerArchivo = Paths.get(rutaCarpeta+"/"+nombreArchivo);
        Optional<Equipo> optionalEquipo=equipoServiceImp.buscarEquipo(equipo);
        if (optionalEquipo.isPresent()) {
            System.out.println("\nAgregando jugadores...");
            try {
                List<String> lines = Files.readAllLines(obtenerArchivo);
                for (String line : lines) {
                    String[] parts = line.split(",");
                    Jugador jugador= new Jugador(parts[0],parts[1],Double.parseDouble(parts[2]), Posiciones.valueOf(parts[3]),Integer.parseInt(parts[4]),Boolean.getBoolean(parts[5]),Integer.parseInt(parts[6]));
                    equipoServiceImp.agregarJugadorAlEquipo(optionalEquipo.get(),jugador);
                }
                System.out.println("jugadores agregados al equipo:"+ optionalEquipo.get().getNombre()+" exitosamente");

            } catch (IOException error) {
                System.out.println("Ha ocurrido un error:" + error);
            }
        } else {
                System.out.println("No se ha encontrado ese equipo");
        }

    }

    @Override
    public void visualizarArchivos() {

        //para obtener la ruta central
        String rutaProyecto = System.getProperty("user.dir");
        String rutaCarpeta = rutaProyecto + "/src/main/resources/Entrada";
        File directorio = new File(rutaCarpeta);

        //pregunta si existe el directorio donde me posiciono
        if (directorio.exists() && directorio.isDirectory()) {
            Collection<File> archivos = FileUtils.listFiles(directorio, new String[]{"txt"}, false);

            if (!archivos.isEmpty()) {
                System.out.println("Archivos CSV en la carpeta " + rutaCarpeta + ":");
                System.out.println("================================");
                for (File archivo : archivos) {
                    System.out.println(archivo.getName());
                }
                System.out.println("================================");

            } else {
                System.out.println("No se encontraron archivos CSV en la carpeta.");
            }
        } else {
            System.out.println("La carpeta especificada no existe o no es un directorio válido.");
        }

    }

    @Override
    public void eliminarJugador(String nombre, String apellido) {
        Optional<Jugador> findJugador= buscarNombreApellidoJugador(nombre,apellido);
        if (findJugador.isPresent()){
            listaJugador.remove(findJugador.get());
            System.out.println("Jugador eliminado...");
        } else {
            System.out.println("Jugador no existe");
        }

    }

    @Override
    public Jugador agregarJugador(String nombreJugador, String apellidoJugador, Double alturaJugador, Posiciones posicion,Integer cantidadGoles,Boolean esCapitan,Integer numeroCamiseta) {
        Jugador jugador = new Jugador(nombreJugador,apellidoJugador,alturaJugador,posicion,cantidadGoles,esCapitan,numeroCamiseta);
        listaJugador.add(jugador);
        return jugador;
    }

    @Override
    public void listarJugador() {
        if (listaJugador.size() == 0) {
            System.out.println("no hay jugadores cargados");
        } else {
            int cantidad = 1;
            for (Jugador jugador : listaJugador) {
                System.out.println("jugador: " + cantidad);
                System.out.println("nombre: " +jugador.getNombre());
                System.out.println("apellido: " + jugador.getApellido());
                System.out.println("altura: " + jugador.getAltura() + " Metros");
                System.out.println("posicion:"+ jugador.getPosiciones());
                System.out.println("cantidad de goles: "+ jugador.getCantidadGoles());
                System.out.println("numero de camiseta: "+ jugador.getNumeroCamiseta());
                System.out.println("Capitan: "+ jugador.getEsCapitan());

                if (cantidad != listaJugador.size()) {
                    System.out.println("-----------------------");
                }
                cantidad++;
            }
        }
    }


}
