package com.jedi.TP1.models;

import com.jedi.TP1.enums.Posiciones;

public class Jugador extends Persona {

    private static Long idJugador= 1L;

    private Double altura;

    private Posiciones posiciones;

    private Integer cantidadGoles;
    private Boolean esCapitan;
    private Integer numeroCamiseta;

    private Equipo equipo;


    public Jugador(String nombre, String apellido, Double altura, Posiciones posiciones, Integer cantidadGoles, Boolean esCapitan, Integer numeroCamiseta) {
        super(nombre,apellido);
        idJugador ++;
        this.altura = altura;
        this.posiciones = posiciones;
        this.cantidadGoles = cantidadGoles;
        this.esCapitan = esCapitan;
        this.numeroCamiseta = numeroCamiseta;

    }

    public Long getIdJugador() {
        return idJugador;
    }


    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Posiciones getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(Posiciones posiciones) {
        this.posiciones = posiciones;
    }

    public Integer getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(Integer cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    public Boolean getEsCapitan() {
        return esCapitan;
    }

    public void setEsCapitan(Boolean esCapitan) {
        this.esCapitan = esCapitan;
    }

    public Integer getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(Integer numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "  nombre:" + nombre +
                "  apellido:" + apellido +
                ", posiciones=" + posiciones +
                ", esCapitan=" + esCapitan +
                ", numeroCamiseta=" + numeroCamiseta +
                ", equipo=" + equipo +
                '}';
    }
}
