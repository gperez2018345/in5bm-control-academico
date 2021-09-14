/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.models.domain;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 27/08/2021
 * @time 04:16:22 PM
 */
public class Horario {
    
    private int horarioId;
    private Time horarioFinal;
    private Time horarioInicio;

    public Horario() {
    }
    
    public Horario(int horarioId) {
        this.horarioId=horarioId;
    }
    
    public Horario(int horarioId, Time horarioFinal, Time horarioInicio) {
        this.horarioId = horarioId;
        this.horarioFinal = horarioFinal;
        this.horarioInicio = horarioInicio;
    }

    public Horario(Time horarioFinal, Time horarioInicio) {
        this.horarioFinal = horarioFinal;
        this.horarioInicio = horarioInicio;
    }

    public int getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(int horarioId) {
        this.horarioId = horarioId;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    @Override
    public String toString() {
        return "Horario{" + "horarioId=" + horarioId + ", horarioFinal=" + horarioFinal + ", horarioInicio=" + horarioInicio + '}';
    }
    
    
}
