/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.ICursoDao;
import com.in5bmgrupo4.models.domain.Curso;
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
 * @time 04:48:46 PM
 */
public class CursoDaoImpl implements ICursoDao{

    private static final String SQL_SELECT = "SELECT curso_id, ciclo, cupo_maximo,cupo_minimo,descripcion,codigo_carrera,horario_id,instructor_id,salon_id FROM curso";
    private static final String SQL_INSERT = "INSERT INTO curso (ciclo, cupo_maximo,cupo_minimo,descripcion,codigo_carrera,horario_id,instructor_id,salon_id) VALUES(?,?,?,?,?,?,?,?);";
    private static final String SQL_DELETE = "DELETE from curso where curso_id = ?";
    private static final String SQL_FIND = "SELECT curso_id, ciclo, cupo_maximo,cupo_minimo,descripcion,codigo_carrera,horario_id,instructor_id,salon_id FROM curso WHERE curso_id=? ";
    private static final String SQL_UPDATE="UPDATE curso SET ciclo=?, cupo_maximo=?, cupo_minimo=?, descripcion=?, codigo_carrera=?,horario_id=?,instructor_id=?,salon_id=? WHERE curso_id=?;";
    
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Curso curso = null;
    List<Curso> listaCurso = new ArrayList<>();
    
    @Override
    public List<Curso> listar() {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int cursoId = rs.getInt("curso_id");
                int ciclo = rs.getInt("ciclo");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descripcion");
                String codigoCarrera = rs.getString("codigo_carrera");
                int horarioId = rs.getInt("horario_id");
                int instructorId = rs.getInt("instructor_id");
                int salonId = rs.getInt("salon_id");
                
                curso = new Curso(cursoId, ciclo, cupoMaximo, cupoMinimo, descripcion, codigoCarrera, horarioId, instructorId, salonId);
                listaCurso.add(curso);     
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
        return listaCurso;
    }

    @Override
    public Curso encontrar(Curso curso) {
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_FIND);
            pstmt.setInt(1, curso.getCursoId());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int ciclo = rs.getInt("ciclo");
                int cupoMaximo = rs.getInt("cupo_maximo");
                int cupoMinimo = rs.getInt("cupo_minimo");
                String descripcion = rs.getString("descripcion");
                String codigoCarrera = rs.getString("codigo_carrera");
                int horarioId = rs.getInt("horario_id");
                int instructorId = rs.getInt("instructor_id");
                int salonId = rs.getInt("salon_id");

                curso.setCiclo(ciclo);
                curso.setCupoMaximo(cupoMaximo);
                curso.setCupoMinimo(cupoMinimo);
                curso.setDescripcion(descripcion);
                curso.setCodigoCarrera(codigoCarrera);
                curso.setHorarioId(horarioId);
                curso.setInstructorId(instructorId);
                curso.setSalonId(salonId);

            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return curso;
    }
    

    @Override
    public int insertar(Curso curso) {
        int rows=0;
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_INSERT);
            pstmt.setInt(1,curso.getCiclo());
            pstmt.setInt(2,curso.getCupoMaximo());
            pstmt.setInt(3,curso.getCupoMinimo());
            pstmt.setString(4, curso.getDescripcion());
            pstmt.setString(5,curso.getCodigoCarrera());
            pstmt.setInt(6,curso.getHorarioId());
            pstmt.setInt(7,curso.getInstructorId());
            pstmt.setInt(8,curso.getSalonId());
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
    public int actualizar(Curso curso) {
        int rows=0;
        try {
            conn=Conexion.getConnection();
            pstmt=conn.prepareStatement(SQL_UPDATE);
            
            pstmt.setInt(1,curso.getCiclo());
            pstmt.setInt(2,curso.getCupoMaximo());
            pstmt.setInt(3,curso.getCupoMinimo());
            pstmt.setString(4, curso.getDescripcion());
            pstmt.setString(5,curso.getCodigoCarrera());
            pstmt.setInt(6,curso.getHorarioId());
            pstmt.setInt(7,curso.getInstructorId());
            pstmt.setInt(8,curso.getSalonId());
            pstmt.setInt(9, curso.getCursoId());
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
    public int eliminar(Curso curso) {
        int rows=0;
        try {
            conn=Conexion.getConnection();
            pstmt= conn.prepareCall(SQL_DELETE);
            pstmt.setInt(1,curso.getCursoId());
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
