package com.jedi.TP1.models;

import com.jedi.TP1.enums.Posiciones;

public class Jugador extends Persona {

    private Long idJugador;

    private Double altura;

    private Posiciones posiciones;

    private Integer cantidadGoles;
    private Boolean esCapitan;
    private Integer numeroCamiseta;

    private Equipo equipo;


    public Jugador(String nombre, String apellido, Long idJugador, Double altura, Posiciones posiciones, Integer cantidadGoles, Boolean esCapitan, Integer numeroCamiseta, Equipo equipo) {
        super(nombre,apellido);
        this.idJugador = idJugador;
        this.altura = altura;
        this.posiciones = posiciones;
        this.cantidadGoles = cantidadGoles;
        this.esCapitan = esCapitan;
        this.numeroCamiseta = numeroCamiseta;
        this.equipo = equipo;

    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
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
}
