/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.idao;

import com.in5bmgrupo4.models.domain.Alumno;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:43:47 PM
 */
public interface IAlumnoDao {
    public List<Alumno> listar();
    public Alumno encontrar(Alumno alumno);
    public int insertar(Alumno alumno);
    public int actualizar (Alumno alumno);
    public int eliminar (Alumno alumno);
}
