/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.HorarioDaoImpl;
import com.in5bmgrupo4.models.domain.Horario;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:39:45 PM
 */
@WebServlet("/ServletHorarioController")
public class ServletHorarioController extends HttpServlet {

    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
       String accion=request.getParameter("accion");
       
       if(accion!=null){
            switch(accion){
                case "listar":
                    listarHorarios(request, response);
                    break;
                    
                case "encontrar":
                    break;
                    
                case "insertar":
                    break;
                
                case "actualizar":
                    break;
                    
                case "eliminar":
                    eliminarHorarios(request, response);
                    break;
            }
        }
    }
   
    private void listarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
       List<Horario> listaHorarios = new HorarioDaoImpl().listar();
       
       HttpSession sesion=request.getSession();
       sesion.setAttribute("listadoHorario", listaHorarios );
       response.sendRedirect("Horario.jsp");
   }
   
    private void eliminarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
       int horarioId= Integer.parseInt(request.getParameter("horarioId"));
       Horario horario=new Horario(horarioId);
       int registrosEliminados=new HorarioDaoImpl().eliminar(horario);
       System.out.println("Cantidad de registros eliminados: "+registrosEliminados);
       listarHorarios(request, response);
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response){
       
   }
   
}
