/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.models.domain;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 27/08/2021
 * @time 04:16:51 PM
 */
public class CarreraTecnica {
    private int codigoCarrera;
    private String nombre;

    public CarreraTecnica() {
    }

    public CarreraTecnica(int codigoCarrera, String nombre) {
        this.codigoCarrera = codigoCarrera;
        this.nombre = nombre;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CarreraTecnica{" + "codigoCarrera=" + codigoCarrera + ", nombre=" + nombre + '}';
    }
    
}
