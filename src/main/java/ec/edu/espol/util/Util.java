package ec.edu.espol.util;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.model.Vehiculo;

import java.io.File;
import java.util.Scanner;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


/**
 *
 * @author micha
 */
public class Util {
    
    private Util(){};
    
    public static int nextID(String nomfile){
        int id = 0;
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                id = Integer.parseInt(tokens[0]);
            }
        }catch(Exception e){
        }
        return id+1;
    }
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
    
    // Verifica si el comprador esta en el sistema. Le das el email a verificar y un archivo de texto con los compradores.
    // Te bota un true si se encuentra en el archivo y false si no lo esta.
    public static boolean verificarComprador(String email,String nomfile){
        ArrayList<String> correoCompradores = new ArrayList<String>();
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                correoCompradores.add(tokens[2]);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(String c: correoCompradores)   {
            if(c == email)  {
                return true;
            }
        }
        return false;
    }
    
    //Para convertir contrase??as en tipo de dato Hash
    //Desde aqui
    private static byte[] getSHA(String contrase??a) throws NoSuchAlgorithmException
    { 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
        return md.digest(contrase??a.getBytes(StandardCharsets.UTF_8)); 
    }
    
    //Esta es la que se llama
    public static String convertirContrase??a(String contrase??a) throws NoSuchAlgorithmException{
        
        BigInteger number = new BigInteger(1, Util.getSHA(contrase??a)); 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
        return hexString.toString(); 
    }
    //Hasta Aqui
    
    // Te bota un true si se encuentra en el archivo y false si no lo esta.
    // Le das la contrase??a ingresada y el archivo vendedores
    // (id, nombre, apellido, organizacion, email, hash)
    private static boolean validarContrase??aVendedor(String correoIngresado, String claveIngresada, String nomfile) throws NoSuchAlgorithmException{
        String hash = Util.convertirContrase??a(claveIngresada);
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                if (correoIngresado.equals(tokens[4]) && hash.equals(tokens[5]))
                    return false;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    //Se llama para validar el ingreso de un Vendedor (Vota True si la contrase??a esta incorrecta y False si no lo esta)
    public static boolean pedirVendedor(Scanner sc) throws NoSuchAlgorithmException{
        System.out.println("Ingrese su correo: ");
        sc.useDelimiter("\n");
        String correo = sc.next();
        System.out.println("Ingrese su contrase??a: ");
        sc.useDelimiter("\n");
        String contrase??a = sc.next();

        boolean resultado = Util.validarContrase??aVendedor(correo, contrase??a, "Vendedores.txt");
        return resultado;
    }
    
    // Validar si el vehiculo se encuentra en el sistema 
    // Te bota un true si se encuentra en el archivo y false si no lo esta.
    public static boolean verificarVehiculo(Vehiculo vehiculo, String nomfile){
        ArrayList<String> placas = new ArrayList<String>();
        try(Scanner sc = new Scanner (new File(nomfile))){
            while (sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                placas.add(tokens[1]);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(String p: placas)   {
            if(vehiculo.getPlaca().equals(p)){
                return true;
            }
        }
        return false;
    }
    
}
