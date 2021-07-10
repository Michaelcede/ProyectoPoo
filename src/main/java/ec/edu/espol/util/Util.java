/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;

import ec.edu.espol.model.Vendedor;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author micha
 */
public class Util {
    
    // Verifica si el vendedor esta en el sistema. Le das un archivo de texto con los vendedores
    // Te bota un true sino se encuentra y false si, si lo esta.
    public boolean verificarVendedor(Vendedor v,String nomfile){
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
    
    
}
