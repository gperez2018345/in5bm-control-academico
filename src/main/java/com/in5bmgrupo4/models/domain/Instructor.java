/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.models.domain;

import java.io.Serializable;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 27/08/2021
 * @time 04:17:08 PM
 */
public class Instructor implements Serializable{

    private static final long serialVersionUID = 1L;
    private int instructorId;
    private String apellidos;
    private String nombre;
    private String direccion;
    private String telefono;

    public Instructor(int instructorId, String apellidos, String nombre, String direccion, String telefono) {
        this.instructorId = instructorId;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Instructor(String apellidos, String nombre, String direccion, String telefono) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Instructor(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Instructor{" + "instructorId=" + instructorId + ", apellidos=" + apellidos + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
