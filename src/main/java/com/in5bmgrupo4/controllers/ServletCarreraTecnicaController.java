/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.CarreraTecnicaDaoImpl;
import com.in5bmgrupo4.models.domain.CarreraTecnica;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:38:49 PM
 */
@WebServlet("/ServletCarreraTecnicaController")
public class ServletCarreraTecnicaController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        
        if(accion != null) {
            switch (accion){
                case "listar":
                    listarCarrerasTecnicas(request, response);
                    break;
                case "encontrar":
                    break;
                    
                case "insertar":
                    break;
                
                case "actualizar":    
                    break;
                case "eliminar":
                    eliminarCarrerasTecnicas(request, response);
                break;
            }
        }
    }    
////////////////////////////////////////////////////////////////////////////////    
    private void listarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<CarreraTecnica> listaCarreras = new CarreraTecnicaDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoCarreraTecnica", listaCarreras);

        response.sendRedirect("CarreraTecnica.jsp");
    }
////////
    private void eliminarCarrerasTecnicas(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String codigo = request.getParameter("codigoCarrera");
        CarreraTecnica carreraTecnica = new CarreraTecnica(codigo);
        int registrosEliminados = new CarreraTecnicaDaoImpl().eliminar(carreraTecnica);
        System.out.println("Cantidad de registros eliminados: " + registrosEliminados);
        listarCarrerasTecnicas(request, response);
    }
////////        

////////////////////////////////////////////////////////////////////////////////
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
       
    }
        
}
    

