package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.ILoginDao;
import com.in5bmgrupo4.models.domain.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
 * @date 15/09/2021
 * @time 12:54:21 PM
 */
public class LoginDaoImpl implements ILoginDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Login login = null;

    private static final String SQL_LOGIN = "SELECT usuario,pass,nombre FROM Usuario WHERE usuario=?;";

    @Override
    public Boolean login(Login login) {
        boolean log = false;
        getPassword(login.getUser());
        
        if (login.getPass().equals(getPassword(login.getUser().trim()))){
            log = true;
        }else{
            log = false;
        }
        return log;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    private String getPassword(String user) {
        String passDecodificado = null;

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareCall(SQL_LOGIN);
            pstmt.setString(1, user);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                
                String usuario = rs.getString("usuario");
                String pass = rs.getString("pass");
                String nombre = rs.getString("nombre");

                passDecodificado = new String(Base64.getDecoder().decode(pass));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();

            }
        }
        return passDecodificado;
    }
    
}
