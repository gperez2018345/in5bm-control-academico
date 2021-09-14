/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.controllers;

import com.in5bmgrupo4.models.dao.HorarioDaoImpl;
import com.in5bmgrupo4.models.domain.Horario;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import javax.servlet.ServletException;
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
    
    private final String JSP_HORARIO="horario/horario.jsp";
    private final String JSP_EDITAR_HORARIO="horario/editar-horario.jsp";

    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
       request.setCharacterEncoding("UTF-8");
       String accion=request.getParameter("accion");
        System.out.println("entrando a do get");
       
       if(accion!=null){
            switch(accion){
                case "listar":
                    listarHorarios(request, response);
                    break;
                    
                case "editar":
                    encontrarHorarios(request, response);
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
       response.sendRedirect(JSP_HORARIO);
   }
   
    private void eliminarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
       int horarioId= Integer.parseInt(request.getParameter("horarioId"));
       Horario horario=new Horario(horarioId);
       int registrosEliminados=new HorarioDaoImpl().eliminar(horario);
       System.out.println("Cantidad de registros eliminados: "+registrosEliminados);
       listarHorarios(request, response);
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       request.setCharacterEncoding("UTF-8");
       System.out.println("entrando a do Post");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarHorarios(request, response);
                    break;
                    
                case "actualizar":
                    actualizarHorarios(request, response);
                    break;
            }
        }
   }
   
   private void insertarHorarios(HttpServletRequest request, HttpServletResponse response)throws IOException{
       System.out.println("entrando a insertar horario");
       String horarioFinalStr=request.getParameter("horarioFinal");
       String horarioInicioStr=request.getParameter("horarioInicio");
       Time horarioFinal=Time.valueOf(horarioFinalStr+":00");
       Time horarioInicio=Time.valueOf(horarioInicioStr+":00");
       Horario horario=new Horario(horarioFinal, horarioInicio);
       System.out.println(horario);
       int registrosAgregados=new HorarioDaoImpl().insertar(horario);
       System.out.println("Cantidad de registros agregados:" + registrosAgregados);
       listarHorarios(request, response);
   }
   
   private void encontrarHorarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       System.out.println("entrando a encontrar horarios");
       int horarioId=Integer.parseInt(request.getParameter("horarioId"));
       Horario horario=new HorarioDaoImpl().encontrar(new Horario(horarioId));
       request.setAttribute("horario", horario);
       request.getRequestDispatcher(JSP_EDITAR_HORARIO).forward(request, response);
       System.out.println(horario);
   }
   
   private void actualizarHorarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
       System.out.println("entrando a actualizar horario");
       int horarioId=Integer.parseInt(request.getParameter("horarioId"));
       String horarioFinalStr=request.getParameter("horarioFinal");
       String horarioInicioStr=request.getParameter("horarioInicio");
       Time horarioFinal=Time.valueOf(horarioFinalStr+":00");
       Time horarioInicio=Time.valueOf(horarioInicioStr+":00");
       Horario horario=new Horario(horarioId, horarioFinal, horarioInicio);
       System.out.println(horario);
       int registrosActualizados=new HorarioDaoImpl().actualizar(horario);
       System.out.println("Cantidad de registros actualizados:" + registrosActualizados);
       listarHorarios(request, response);
   }
   
   
}