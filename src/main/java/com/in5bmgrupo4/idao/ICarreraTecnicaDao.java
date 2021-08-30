/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.idao;

import com.in5bmgrupo4.models.domain.CarreraTecnica;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:45:13 PM
 */
public interface ICarreraTecnicaDao {
    public List<CarreraTecnica> listar();
    public CarreraTecnica encontrar(CarreraTecnica carreraTecnica);
    public int insertar(CarreraTecnica carreraTecnica);
    public int actualizar (CarreraTecnica carreraTecnica);
    public int eliminar (CarreraTecnica carreraTecnica);
}
