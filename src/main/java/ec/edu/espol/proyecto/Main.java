/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto;
import java.util.Scanner;

/**
 *
 * @author micha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Menu de opciones principal
       
        Scanner leer = new Scanner(System.in);
        
        int n;
        boolean salir = false;
        
        while(!salir){
            System.out.println("Menú de Opciones");
            System.out.println("");
            System.out.println("1. Vendedor");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");

            try(){
                System.out.print("Elije una opcion del menú: ");
                n = leer.nextInt(); //n recoge el valor escrito por teclado (opcion del menu)

                switch(n){
                    case 1:
                         System.out.println("Has escogido la opción Vendedor");
                         System.out.println("-------------------------------");
                         int op1 = 0;
                         do{
                            System.out.println("1. Registrar un nuevo vendedor");
                            System.out.println("2. Ingresar un nuevo vehículo");
                            System.out.println("3. Aceptar oferta");
                            System.out.println("4. Regresar");
                            System.out.println("");
                            System.out.println("Ingrese una opción: ");
                            int o = leer.nextInt();
                            switch(o)
                            {
                                case 1: 
                                    System.out.println("Registrar un nuevo vendedor");
                                    System.out.println("-------------------------------");
                                    break;
                                case 2: 
                                    System.out.println("Ingresar un nuevo vehículo");
                                    System.out.println("-------------------------------");
                                    break;
                                case 3: 
                                    System.out.println("Aceptar oferta");
                                    System.out.println("-------------------------------");
                                    break;
                                case 4: break;
                                default:
                                    System.out.println("No has escogido una opcion del menú");
                            }
                        } while(op1 != 4);
                        break;

                    case 2:
                        System.out.println("Has escogido la opción Comprador");
                        System.out.println("--------------------------------");
                        int op2 = 0;
                        do{
                        System.out.println("1. Registrar un nuevo comprador");
                        System.out.println("2. Ofertar por un vehículo");
                        System.out.println("3. Regresar");
                        } while(op2 != 3);
                        break; 
                    case 3:
                        salir = true;
                        System.out.println("kuchau");
                        break;
                    default:
                         System.out.println("No has escogido una opcion del menú");
                }
            }catch(InputMismatchException e){
                System.out.println("Debes ingresar un número");
                leer.next();
            }
        }
        
        System.out.println("Fin del meun");
        // TODO code application logic here
        
    }
    
}
