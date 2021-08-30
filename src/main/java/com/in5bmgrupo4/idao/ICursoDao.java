/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.idao;

import com.in5bmgrupo4.models.domain.Curso;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:45:26 PM
 */
public interface ICursoDao {
    public List<Curso> listar();
    public Curso encontrar(Curso curso);
    public int insertar(Curso curso);
    public int actualizar (Curso curso);
    public int eliminar (Curso curso);
}
