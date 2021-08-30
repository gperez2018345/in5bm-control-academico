/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.idao;

import com.in5bmgrupo4.models.domain.Horario;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:45:42 PM
 */
public interface IHorarioDao {
    public List<Horario> listar();
    public Horario encontrar(Horario horario);
    public int insertar(Horario horario);
    public int actualizar (Horario horario);
    public int eliminar (Horario horario);
}
