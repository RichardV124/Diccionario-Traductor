/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Andres
 */
public class Usuario {

    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String nombreUsuario;
    private String contraseña;
    private String preguntaSeg;
    private String respuestaSeg;

    public Usuario(String nombre, String apellido, String email, String genero, String nombreUsuario, String contraseña, String preguntaSeg, String respuestaSeg) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.preguntaSeg = preguntaSeg;
        this.respuestaSeg = respuestaSeg;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPreguntaSeg() {
        return preguntaSeg;
    }

    public void setPreguntaSeg(String preguntaSeg) {
        this.preguntaSeg = preguntaSeg;
    }

    public String getRespuestaSeg() {
        return respuestaSeg;
    }

    public void setRespuestaSeg(String respuestaSeg) {
        this.respuestaSeg = respuestaSeg;
    }
    
    
}
