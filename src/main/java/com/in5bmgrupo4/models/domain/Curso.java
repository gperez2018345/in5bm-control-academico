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
 * @time 04:17:18 PM
 */
public class Curso {
    private int cursoId;
    private int ciclio;
    private int cupoMaximo;
    private int cupoMinimo;
    private String descripcion;
    private int codigoCarrera;
    private int horarioId;
    private int instructorId;
    private int salonId;

    public Curso() {
    }

    public Curso(int cursoId, int ciclio, int cupoMaximo, int cupoMinimo, String descripcion, int codigoCarrera, int horarioId, int instructorId, int salonId) {
        this.cursoId = cursoId;
        this.ciclio = ciclio;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
        this.descripcion = descripcion;
        this.codigoCarrera = codigoCarrera;
        this.horarioId = horarioId;
        this.instructorId = instructorId;
        this.salonId = salonId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getCiclio() {
        return ciclio;
    }

    public void setCiclio(int ciclio) {
        this.ciclio = ciclio;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getSalonId() {
        return salonId;
    }

    public void setSalonId(int salonId) {
        this.salonId = salonId;
    }

    @Override
    public String toString() {
        return "Curso{" + "cursoId=" + cursoId + ", ciclio=" + ciclio + ", cupoMaximo=" + cupoMaximo + ", cupoMinimo=" + cupoMinimo + ", descripcion=" + descripcion + ", codigoCarrera=" + codigoCarrera + ", horarioId=" + horarioId + ", instructorId=" + instructorId + ", salonId=" + salonId + '}';
    }
    
}
