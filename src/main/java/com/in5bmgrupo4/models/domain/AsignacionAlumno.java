/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.models.domain;
import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 27/08/2021
 * @time 04:17:29 PM
 */
public class AsignacionAlumno implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String asignacionId;
    private String carne;
    private int cursoId;
    private  Date fechaAsignacion;

    public AsignacionAlumno() {
    }

    public AsignacionAlumno(String asignacionId, String carne, int cursoId, Date fechaAsignacion) {
        this.asignacionId = asignacionId;
        this.carne = carne;
        this.cursoId = cursoId;
        this.fechaAsignacion = fechaAsignacion;
    }
    
    public AsignacionAlumno(String asignacionId) {
        this.asignacionId = asignacionId;
    }

    public AsignacionAlumno(String carne, int cursoId, Date fechaAsignacion) {
        this.carne = carne;
        this.cursoId = cursoId;
        this.fechaAsignacion = fechaAsignacion;
    }
    
    public String getAsignacionId() {
        return asignacionId;
    }

    public void setAsignacionId(String asignacionId) {
        this.asignacionId = asignacionId;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    @Override
    public String toString() {
        return "AsignacionAlumno{" + "asignacionId=" + asignacionId + ", carne=" + carne + ", cursoId=" + cursoId + ", fechaAsignacion=" + fechaAsignacion + '}';
    }
    
}
