
package com.in5bmgrupo4.models.domain;

/**
 *
 * @author Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
 * @date 15/09/2021
 * @time 12:51:32 PM
 */
public class Login {

    private String user;
    private String pass;
    private String nombre;
    
    public Login(){
    }

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Login(String user, String pass, String nombre) {
        this.user = user;
        this.pass = pass;
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Login{" + "user=" + user + ", pass=" + pass + ", nombre=" + nombre + '}';
    }
    
    
    
    
}
