package com.in5bmgrupo4.models.dao;

import com.in5bmgrupo4.db.Conexion;
import com.in5bmgrupo4.idao.ILoginDao;
import com.in5bmgrupo4.models.domain.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_LOGIN);
            pstmt.setString(1, login.getUser());
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String user=rs.getString("usuario");
                    String password = rs.getString("pass");
                    String nombreUser = rs.getString("nombre");
                    log = password.equals(login.getPass());
                    this.login=new Login(user, password, nombreUser);
                }
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
        return log;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    
}
