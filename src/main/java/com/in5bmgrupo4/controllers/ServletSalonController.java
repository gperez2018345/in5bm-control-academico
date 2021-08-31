/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.SalonDaoImpl;
import com.in5bmgrupo4.models.domain.Salon;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:41:28 PM
 */

@WebServlet("/ServletSalonController")
public class ServletSalonController extends HttpServlet{
    
    
    @Override 
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException{
         String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarSalon(request, response);
                    break;
                case "editar'":
                    break;
                case "eliminar":
                 eliminarSalon(request, response);
                    break;
            }
        }
        

    }
    
    
    private void listarSalon (HttpServletRequest request, HttpServletResponse response ) throws IOException{
        List<Salon> listaSalon = new SalonDaoImpl().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoSalon", listaSalon);
        response.sendRedirect("Salon.jsp");
    }
    
   private void eliminarSalon(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int salonId = Integer.parseInt(request.getParameter("salonId"));
        Salon salones = new Salon(salonId);
        int registrosEliminados = new SalonDaoImpl().eliminar(salones);
        System.out.println("Cantidad de registros eliminados:" + registrosEliminados);
        listarSalon(request, response);
   }
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response){
       
   }
}

