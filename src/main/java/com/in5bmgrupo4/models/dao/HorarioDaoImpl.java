/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.IHorarioDao;
import com.in5bmgrupo4.models.domain.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 28/08/2021
 * @time 04:48:58 PM
 */
public class HorarioDaoImpl implements IHorarioDao{
    
    private static final String SQL_SELECT="SELECT horario_id, horario_final, horario_inicio FROM Horario";
    private static final String SQL_DELETE="DELETE FROM Horario WHERE horario_id=?";

    private Connection conn=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs= null;
    private Horario horario=null;
    private List<Horario> listaHorarios= new ArrayList<>();
    
    @Override
    public List<Horario> listar() {
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_SELECT);
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                int horarioId=rs.getInt("horario_id");
                Time horarioFinal=rs.getTime("horario_final");
                Time horarioInicio=rs.getTime("horario_inicio");
            
                horario=new Horario(horarioId, horarioFinal, horarioInicio);
                listaHorarios.add(horario);
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
        return listaHorarios;
    }

    @Override
    public Horario encontrar(Horario horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Horario horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Horario horario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Horario horario) {
        int rows=0;
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, horario.getHorarioId());
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
