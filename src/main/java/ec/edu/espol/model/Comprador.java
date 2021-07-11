/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author micha
 */
public class Comprador {
    private String nombres;
    private String apellidos;
    private String correo_electronico;
    private String organizacion;
    private String correo;
    private String clase;

    public Comprador(String nombres, String apellidos, String correo_electronico, String organizacion, String correo, String clase) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo_electronico = correo_electronico;
        this.organizacion = organizacion;
        this.correo = correo;
        this.clase = clase;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
}
