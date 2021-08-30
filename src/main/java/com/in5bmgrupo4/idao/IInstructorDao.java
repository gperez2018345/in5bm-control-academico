/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.idao;

import com.in5bmgrupo4.models.domain.Instructor;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:45:54 PM
 */
public interface IInstructorDao {
    public List<Instructor> listar();
    public Instructor encontrar(Instructor instructor);
    public int insertar(Instructor instructor);
    public int actualizar (Instructor instructor);
    public int eliminar (Instructor instructor);
}
