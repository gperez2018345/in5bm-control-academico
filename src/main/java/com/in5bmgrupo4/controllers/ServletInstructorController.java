/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.InstructorDaoImpl;
import com.in5bmgrupo4.models.domain.Instructor;
import java.io.IOException;
import java.util.List;
import javax.persistence.Id;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:40:12 PM
 */

public class ServletInstructorController{

    
    
    
    

    private void insertarInstructores(HttpServletRequest request, HttpServletResponse response)throws IOException{
        System.out.println("entrando a insertar a instructores");
        String Id=request.getParameter("Id");
        String apellidos=request.getParameter("apellidos");
        String nombres=request.getParameter("nombres");
        String direccion=request.getParameter("direccion");
        String telefono=request.getParameter("telefono");
        Instructor instructor= new Instructor(Id, apellidos, nombres, direccion, telefono);
        System.out.println(instructor);
        int registrosAgregados=new InstructorDaoImpl().insertar(instructor);
        System.out.println("Cantidad de registros agregados: " + registrosAgregados);
        listarInstructores(request, response);
    }

}
  

