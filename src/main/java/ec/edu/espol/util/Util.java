/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Vendedor;

import java.io.File;
import java.util.Scanner;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author micha
 */
public class Util {
    
    // Verifica si el vendedor esta en el sistema. Le das un onjeto Vendedor y un archivo de texto con los vendedores
    // Te bota un true sino se encuentra y false si, si lo esta.
    public static boolean verificarVendedor(Vendedor v,String nomfile){
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if(v.getEmail().equals(tokens[3])){
                    return false;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    // Verifica si el comprador esta en el sistema. Le das un archivo de texto con los compradores
    // Te bota un true sino se encuentra y false si, si lo esta.
    public static boolean verificarComprador(Comprador c,String nomfile){
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if(c.getEmail().equals(tokens[3])){
                    return false;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    //Para convertir contraseñas en tipo de dato Hash
    //Desde aqui
    private static byte[] getSHA(String contraseña) throws NoSuchAlgorithmException
    { 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
        return md.digest(contraseña.getBytes(StandardCharsets.UTF_8)); 
    }
    
    //Esta es la que se llama
    public static String convertirContraseña(String contraseña) throws NoSuchAlgorithmException{
        
        BigInteger number = new BigInteger(1, Util.getSHA(contraseña)); 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
        return hexString.toString(); 
    }
    //Hasta Aqui
    
    
    //Validar si la contraseña se encuentra en el sistema 
    // Te bota un true sino se encuentra y false si, si lo esta.
    public static boolean validarContraseñaVendedor(String claveIngresada, String nomfile) throws NoSuchAlgorithmException{
        String hash = Util.convertirContraseña(claveIngresada);
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if(hash.equals(tokens[4])){
                    return false;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    //Validar si el vehiculo se encuentra en el sistema 
    // Te bota un true sino se encuentra y false si, si lo esta.
    // Le das la placa del vehiculo a ingresar y el archivo vendedores
    public static boolean validarVehiculo(String placaIngresada, String nomfile){
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if(placaIngresada.equals(tokens[0])){
                    return false;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
}
