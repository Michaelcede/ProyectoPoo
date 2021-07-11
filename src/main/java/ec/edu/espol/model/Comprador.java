/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author micha
 */
public class Comprador {
    private String nombre;
    private String apellido;
    private String correo_electronico;
    private String organizacion;
    private String clase;

    public Comprador(String nombre, String apellido, String correo_electronico, String organizacion, String clase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.organizacion = organizacion;
        this.clase = clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
    //(String nombre, String apellido, String email, String organizacion, String clave)
    public static Comprador leerTeclado(Scanner sc) throws NoSuchAlgorithmException{
        
        System.out.println("Ingrese nombre del Comprador: ");
        sc.useDelimiter("\n");
        String nombre = sc.next();
        System.out.println("Ingrese apellido del Comprador: ");
        sc.useDelimiter("\n");
        String apellido = sc.next();
        System.out.println("Ingrese correo del Comprador: ");
        sc.useDelimiter("\n");    
        String email = sc.next();
        System.out.println("Ingrese organizacion del Comprador: ");
        sc.useDelimiter("\n");
        String organizacion = sc.next();
        System.out.println("Ingrese contraseña del Comprador: ");
        sc.useDelimiter("\n");
        String contraseña = sc.next();
        //Convertimos la contraseña
        String hash = Util.convertirContraseña(contraseña);
        //Creamos el Objeto Comprador
        Comprador comprador = new Comprador(nombre, apellido, email, organizacion, hash);
        
        return comprador;
    }
    
    //Metodo para guardar Comprador en archivo de texto
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.nombre+"|"+this.apellido+"|"+this.email+"|"+this.organizacion+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String toString(){
        return nombre + "," + apellido + "," + email + "," + organizacion + "," + clave;
    }
    
}
