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
    private static final String SQL_INSERT="INSERT INTO Alumno(carne, apellidos, nombres, email)VALUES(?,?,?,?);";
    private static final String SQL_FIND="SELECT carne, apellidos, nombres, email FROM Alumno WHERE carne=?;";
    private static final String SQL_UPDATE="UPDATE Alumno SET apellidos=?, nombres=?, email=? WHERE carne=?;";
    
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
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_FIND);
            pstmt.setString(1, alumno.getCarne());
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                String apellidos=rs.getString("apellidos");
                String nombres=rs.getString("nombres");
                String email=rs.getString("email");
            
                alumno.setApellidos(apellidos);
                alumno.setNombres(nombres);
                alumno.setEmail(email);
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
        return alumno;
    }

    @Override
    public int insertar(Alumno alumno) {
        int rows=0;
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1,alumno.getCarne());
            pstmt.setString(2,alumno.getApellidos());
            pstmt.setString(3,alumno.getNombres());
            pstmt.setString(4,alumno.getEmail());
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(conn);
            Conexion.close(pstmt);
        }
        return rows;
    }

    @Override
    public int actualizar(Alumno alumno) {
        int rows=0;
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1,alumno.getApellidos());
            pstmt.setString(2,alumno.getNombres());
            pstmt.setString(3,alumno.getEmail());
            pstmt.setString(4,alumno.getCarne());
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(conn);
            Conexion.close(pstmt);
        }
        return rows;
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
