/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.ICarreraTecnicaDao;
import com.in5bmgrupo4.models.domain.CarreraTecnica;
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
 * @time 04:48:27 PM
 */
public class CarreraTecnicaDaoImpl implements ICarreraTecnicaDao{
    
    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre FROM CarreraTecnica";
    private static final String SQL_DELETE = "DELETE FROM CarreraTecnica WHERE codigo_carrera = ?";
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs= null;
    private CarreraTecnica carrera = null;
    private List<CarreraTecnica> listaCarrerasTecnicas = new ArrayList<>();
    
    
    @Override
    public List<CarreraTecnica> listar() {
        try{
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                String codigoCarrera = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre");
                
                carrera = new CarreraTecnica(codigoCarrera, nombre);
                listaCarrerasTecnicas.add(carrera);
            }
            
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaCarrerasTecnicas;
    }

    @Override
    public CarreraTecnica encontrar(CarreraTecnica carreraTecnica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(CarreraTecnica carreraTecnica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(CarreraTecnica carreraTecnica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(CarreraTecnica carreraTecnica) {
        int rows=0;
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1, carreraTecnica.getCodigoCarrera());
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
