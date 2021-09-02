/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.models.domain.Instructor;
import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.IInstructorDao;
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
 * @time 04:49:11 PM
 */
public class InstructorDaoImpl implements IInstructorDao {

    private static final String SQL_SELECT = "SELECT instructor_id, apellidos, nombre, direccion, telefono FROM Instructor";
    private static final String SQL_DELETE = "DELETE FROM Instructor WHERE instructor_id=?";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Instructor instructor = null;
    private List<Instructor> listaInstructores = new ArrayList<>();

    @Override
    public List<Instructor> listar() {

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int instructorId = rs.getInt("instructor_id");
                String apellidos = rs.getString("apellidos");
                String nombres = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");

                instructor = new Instructor(instructorId, apellidos, nombres, direccion, telefono);
                listaInstructores.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {

            Conexion.close(conn);
            Conexion.close(pstmt);
            Conexion.close(rs);

        }
        return listaInstructores;
    }

    @Override
    public Instructor encontrar(Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Instructor instructor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Instructor instructor) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, instructor.getInstructorId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(pstmt);
        }
        return rows;
    }

}
