package ec.edu.espol.proyecto_poo;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;

import ec.edu.espol.util.Util;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alecs
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        int n;
        boolean salir = false;
        
        while(!salir){
            System.out.println("Menú de Opciones");
            System.out.println("----------------");
            System.out.println("1. Vendedor");
            System.out.println("2. Comprador");
            System.out.println("3. Salir");
            System.out.println("");

            try{
                System.out.print("Elije una opcion del menú: ");
                n = leer.nextInt(); //n recoge el valor escrito por teclado (opcion del menu)

                switch(n){
                    case 1:
                         System.out.println("Has escogido la opción Vendedor");
                         System.out.println("-------------------------------");
                         boolean obsal1 = false;
                         while(!obsal1){
                            System.out.println("1. Registrar un nuevo vendedor");
                            System.out.println("2. Ingresar un nuevo vehículo");
                            System.out.println("3. Aceptar oferta");
                            System.out.println("4. Regresar");
                            System.out.println("");
                            
                            try{
                                System.out.println("Ingrese una opción: ");
                                int o = leer.nextInt();
                                switch(o)
                                {
                                    case 1: 
                                        System.out.println("Registrar un nuevo vendedor");
                                        System.out.println("-------------------------------");
                                        //Creamos el objeto Vendedor
                                        //Llamamos a leerteclado de Vendedor
                                        Vendedor vendedor;
                                        vendedor = Vendedor.leerTeclado(leer,"Vendedores.txt");
                                        //Verificamos si el correo ingresado se encuentra en el sistema
                                        boolean verificar = Util.verificarVendedor(vendedor, "Vendedores.txt");
                                        while(verificar){
                                            System.out.println("El correo con el que se desea registrar ya se encuentra en el sistema!!");
                                            System.out.println("Ingrese sus datos nuevamente");
                                            System.out.println("-------------------------------");
                                            vendedor = Vendedor.leerTeclado(leer,"Vendedores.txt");
                                            verificar = Util.verificarVendedor(vendedor, "Vendedores.txt");
                                        }
                                        System.out.println("-------------------------------");
                                        System.out.println("El vendedor ha sido registrado exitosamente!!");
                                        System.out.println("-------------------------------");
                                        // Guardamos el vendedor en el sistema
                                        vendedor.saveFile("Vendedores.txt");
                                        break;
                                    case 2: 
                                        System.out.println("Ingresar un nuevo vehículo");
                                        System.out.println("-------------------------------");
                                        Vehiculo vehiculo = Vehiculo.leerTeclado(leer,"Vehiculos.txt");
                                        System.out.println(vehiculo);
                                        vehiculo.saveFile("Vehiculos.txt");
                                        break;
                                    case 3: 
                                        System.out.println("Aceptar oferta");
                                        System.out.println("-------------------------------");
                                        break;
                                    case 4: 
                                        obsal1 = true; 
                                        break;
                                    default:
                                        System.out.println("No has escogido una opcion del menú");
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Debes ingresar un número");
                                leer.next();
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Has escogido la opción Comprador");
                        System.out.println("--------------------------------");
                        boolean obsal2 = false;
                        while(!obsal2){
                            System.out.println("1. Registrar un nuevo comprador");
                            System.out.println("2. Ofertar por un vehículo");
                            System.out.println("3. Regresar");
                            System.out.println("");
                            
                            try{
                                System.out.println("Ingrese una opción: ");
                                int o = leer.nextInt();
                                switch(o)
                                    {
                                        case 1: 
                                            System.out.println("Registrar un nuevo comprador");
                                            System.out.println("-------------------------------");
                                            //Creamos el objeto Comprador
                                            //Llamamos a leerteclado de Comprador
                                            Comprador comprador;
                                            comprador = Comprador.leerTeclado(leer,"Compradores.txt");
                                            //Verificamos si el correo ingresado se encuentra en el sistema
                                            boolean verificar = Util.verificarComprador(comprador, "Compradores.txt");
                                            while(verificar){
                                                System.out.println("El correo con el que se desea registrar ya se encuentra en el sistema!!");
                                                System.out.println("Ingrese sus datos nuevamente");
                                                System.out.println("-------------------------------");
                                                comprador = Comprador.leerTeclado(leer,"Compradores.txt");
                                                verificar = Util.verificarComprador(comprador, "Compradores.txt");
                                            }
                                            System.out.println("-------------------------------");
                                            System.out.println("El comprador ha sido registrado exitosamente!!");
                                            System.out.println("-------------------------------");
                                            // Guardamos el comprador en el sistema
                                            comprador.saveFile("Compradores.txt");
                                            break;
                                        case 2: 
                                            System.out.println("Ofertar por un vehículo");
                                            System.out.println("-------------------------------");
                                            break;
                                        case 3: 
                                            obsal2 = true;
                                            break;
                                        default:
                                            System.out.println("No has escogido una opcion del menú");
                                    }
                            }catch(InputMismatchException e){
                                System.out.println("Debes ingresar un número");
                                leer.next();
                            }
                        }
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
        
        System.out.println("Fin del menu");
        
        
    }
        
}
