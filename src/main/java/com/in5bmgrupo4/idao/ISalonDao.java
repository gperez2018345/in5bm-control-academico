/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.idao;

import com.in5bmgrupo4.models.domain.Salon;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:46:10 PM
 */
public interface ISalonDao {
    public List<Salon> listar();
    public Salon encontrar(Salon salon);
    public int insertar(Salon salon);
    public int actualizar (Salon salon);
    public int eliminar (Salon salon);
}
