/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in5bmgrupo4.db;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Gerardo Andree Pérez Cabrera
 * @date 27/08/2021
 * @time 02:44:18 PM
 */
public class Conexion {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB = "control_academico";
    private static final String USER = "root";
    private static final String PASS = "admin";

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB + "?allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=false&useTimezone=true";

    private static BasicDataSource basicDataSource;

    public static DataSource getDataSource() {
        // Patrón Singleton
        if (basicDataSource == null) {
            basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(URL);
            basicDataSource.setUsername(USER);
            basicDataSource.setPassword(PASS);
            basicDataSource.setInitialSize(25);
        }
        return basicDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
