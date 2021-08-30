/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.idao;

import com.in5bmgrupo4.models.domain.AsignacionAlumno;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:44:39 PM
 */
public interface IAsignacionAlumnoDao {
    public List<AsignacionAlumno> listar();
    public AsignacionAlumno encontrar(AsignacionAlumno asignacionAlumno);
    public int insertar(AsignacionAlumno asignacionAlumno);
    public int actualizar (AsignacionAlumno asignacionAlumno);
    public int eliminar (AsignacionAlumno asignacionAlumno);
}
