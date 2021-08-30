/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.IAlumnoDao;
import com.in5bmgrupo4.models.domain.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:47:05 PM
 */
public class AlumnoDaoImpl implements IAlumnoDao{

    private static final String SQL_SELECT="SELECT carne, apellidos, nombres, email FROM Alumno";
    private static final String SQL_DELETE="DELETE FROM Alumno WHERE carne=?";
    
    private Connection conn=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs= null;
    private Alumno alumno=null;
    private List<Alumno> listaAlumnos= new ArrayList<>();
    
    @Override
    public List<Alumno> listar() {
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_SELECT);
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                String carne=rs.getString("carne");
                String apellidos=rs.getString("apellidos");
                String nombres=rs.getString("nombres");
                String email=rs.getString("email");
            
                alumno=new Alumno(carne, apellidos, nombres, email);
                listaAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(conn);
            Conexion.close(pstmt);
            Conexion.close(rs);
        }
        return listaAlumnos;
    }

    @Override
    public Alumno encontrar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Alumno alumno) {
        int rows=0;
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, alumno.getCarne());
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(conn);
            Conexion.close(pstmt);
        }
        return rows;
    }

}
