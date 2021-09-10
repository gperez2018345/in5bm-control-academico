/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.IAsignacionAlumnoDao;
import com.in5bmgrupo4.models.domain.AsignacionAlumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:47:26 PM
 */
public class AsignacionAlumnoDaoImpl implements IAsignacionAlumnoDao {

    private static final String SQL_SELECT = "SELECT asignacion_id, carne, curso_id,fecha_asignacion FROM asignacionAlumno";
    private static final String SQL_DELETE = "DELETE from asignacionAlumno where asignacion_id = ?";
    private static final String SQL_INSERT = "INSERT INTO asignacionAlumno (asignacion_id, carne, curso_id, fecha_asignacion) VALUES (?,?,?,?)";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private AsignacionAlumno asignacionAlumno = null;
    List<AsignacionAlumno> listaAsignacionAlumno = new ArrayList<>();

    @Override
    public List<AsignacionAlumno> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String asignacionId = rs.getString("asignacion_id");
                String carne = rs.getString("carne");
                int cursoId = rs.getInt("curso_id");
                Date fechaAsignacion = rs.getDate("fecha_asignacion");

                asignacionAlumno = new AsignacionAlumno(asignacionId, carne, cursoId, fechaAsignacion);
                listaAsignacionAlumno.add(asignacionAlumno);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaAsignacionAlumno;
    }

    @Override
    public AsignacionAlumno encontrar(AsignacionAlumno asignacionAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(AsignacionAlumno asignacionAlumno) {
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, asignacionAlumno.getAsignacionId());
            pstmt.setString(2, asignacionAlumno.getCarne());
            pstmt.setInt(3, asignacionAlumno.getCursoId());
            pstmt.setDate(4, asignacionAlumno.getFechaAsignacion());

            System.out.println(pstmt.toString());

            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int actualizar(AsignacionAlumno asignacionAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(AsignacionAlumno asignacionAlumno) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareCall(SQL_DELETE);
            pstmt.setString(1, asignacionAlumno.getAsignacionId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

}