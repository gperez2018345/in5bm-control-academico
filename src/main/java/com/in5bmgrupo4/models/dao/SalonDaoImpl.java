/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.ISalonDao;
import com.in5bmgrupo4.models.domain.Salon;
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
 * @time 04:49:47 PM
 */
public class SalonDaoImpl implements ISalonDao {

    private static final String SQL_SELECT = "Select salon_id, capacidad, descripcion, nombre_salon from Salon";
    private static final String SQL_DELETE = "delete from Salon where salon_id =?";
    private static final String SQL_INSERT = "INSERT INTO salon(capacidad, descripcion, nombre_salon)VALUES(?,?,?);";
    private static final String SQL_FIND = "SELECT salon_id, capacidad, descripcion, nombre_salon from Salon where salon_id=?;";
    private static final String SQL_UPDATE = "UPDATE Salon set capacidad=?, descripcion=?,nombre_salon=? where salon_id=?;";
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Connection conn = null;
    private Salon salon = null;
    List<Salon> salones = new ArrayList<>();

    @Override
    public List<Salon> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int salonId = rs.getInt("salon_id");
                int capacidad = rs.getInt("capacidad");
                String descripcion = rs.getString("descripcion");
                String nombreSalon = rs.getString("nombre_salon");
                salon = new Salon(salonId, capacidad, descripcion, nombreSalon);
                salones.add(salon);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
            Conexion.close(rs);

        }
        return salones;
    }

    @Override
    public Salon encontrar(Salon salon) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_FIND);
            pstmt.setInt(1, salon.getSalonId());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int capacidad = rs.getInt("capacidad");
                String descripcion = rs.getString("descripcion");
                String nombreSalon = rs.getString("nombre_salon");
                salon.setCapacidad(capacidad);
                salon.setDescripcion(descripcion);
                salon.setNombreSalon(nombreSalon);
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
        return salon;
    }

    @Override
    public int insertar(Salon salon) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, salon.getCapacidad());
            pstmt.setString(2, salon.getDescripcion());
            pstmt.setString(3, salon.getNombreSalon());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(pstmt);
        }
        return rows;
    }

    @Override
    public int actualizar(Salon salon) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, salon.getCapacidad());
            pstmt.setString(2, salon.getDescripcion());
            pstmt.setString(3, salon.getNombreSalon());
            pstmt.setInt(4, salon.getSalonId());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(pstmt);
        }
        return rows;
    }

    @Override
    public int eliminar(Salon salon) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, salon.getSalonId());
            System.out.println(pstmt.toString());
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

