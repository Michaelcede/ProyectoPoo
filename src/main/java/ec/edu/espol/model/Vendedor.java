package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Vendedor {
    private int id;
    private String nombre;
    private String apellido;
    private String organizacion;
    private String email;
    private String clave;

    public Vendedor(int id, String nombre, String apellido, String organizacion, String email, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.email = email;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    //(String nombre, String apellido, String email, String organizacion, String clave)
    public static Vendedor leerTeclado(Scanner sc, String nomfile) throws NoSuchAlgorithmException{
        
        System.out.println("Ingrese nombre del Vendedor: ");
        sc.useDelimiter("\n");
        String nombre = sc.next();
        System.out.println("Ingrese apellido del Vendedor: ");
        sc.useDelimiter("\n");
        String apellido = sc.next();
        System.out.println("Ingrese la organizacion a la que pertenece: ");
        sc.useDelimiter("\n");    
        String organizacion = sc.next();
        System.out.println("Ingrese un email: ");
        sc.useDelimiter("\n");
        String email = sc.next();
        System.out.println("Ingrese una contrase??a: ");
        sc.useDelimiter("\n");
        String contrase??a = sc.next();
        //Convertimos la contrase??a
        String hash = Util.convertirContrase??a(contrase??a);
        //Creamos el Objeto Vendedor
        int id = Util.nextID(nomfile);
        Vendedor vendedor = new Vendedor(id, nombre, apellido, organizacion, email, hash);
        
        return vendedor;
    }
    
    //Metodo para guardar Comprador en archivo de texto
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombre+"|"+this.apellido+"|"+this.organizacion+"|"+this.email+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String toString(){
        return nombre + "," + apellido + "," + organizacion + "," + email + "," + clave;
    }
}
