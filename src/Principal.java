
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Miguel
 */
public class Principal {
    
    public static int buscarNumeroCuenta(Cuenta cuentas[],int n){
        int i=0,indice=0;
        boolean encontrado = false;
        
        //Busqueda secuencial
        while((i<cuentas.length) && (encontrado == false)){
            if(cuentas[i].getNumeroCuenta() == n ){
             encontrado = true;
             indice = i;
            }
            i++;
        }
        if (encontrado == false){
            indice = -1;
        }
        return indice;
    }
    
    public static void main(String[] args){
     Scanner entrada = new Scanner(System.in);
     String nombre,apellido,dni;
     int numeroCuenta,nCuentas,opcion,indiceCuenta;
     double saldo, cantidad;
     Cuenta cuentas[];
     Cliente cliente;
     
     System.out.print("Digite el nombre del cliente: ");
     nombre = entrada.nextLine();
     System.out.print("Digite el apellido del cliente: ");
     apellido = entrada.nextLine();
     System.out.print("Digite el DNI del cliente: ");
     dni = entrada.nextLine();
     System.out.print("Digite cuantas cuentas tiene: ");
     nCuentas = entrada.nextInt();
     
     cuentas = new Cuenta[nCuentas];
     
     for (int i=0;i<cuentas.length;i++){
         System.out.print("\nDigite los datos para la cuenta " + (i+1)+":");
         System.out.print("\nDigite el numero de cuenta: ");
         numeroCuenta = entrada.nextInt();
         System.out.print("Digite el saldo de la cuenta: ");
         saldo = entrada.nextDouble();
         
         cuentas[i] = new Cuenta(numeroCuenta,saldo);
     }
     
     cliente = new Cliente(nombre, apellido, dni, cuentas);
     
     do{
         System.out.print("\t.:MENU:.");
         System.out.println("\n1. Ingresar dinero en la cuenta");
         System.out.println("2. Retirar dinero en la cuenta");
         System.out.println("3. Consultar dinero en la cuenta");
         System.out.println("4. Salir");
         System.out.println("Digite una opcion: ");
         opcion = entrada.nextInt();
         
         switch(opcion){
             case 1: System.out.print("Digite el numero de cuenta: ");
                        numeroCuenta = entrada.nextInt();
                        indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);
                        
                        if(indiceCuenta == -1){
                            System.out.print("\nNumero de cuenta erroneo");
                        }
                        else{
                            System.out.print("\nDigite la cantidad de dinero a ingresar:");
                            cantidad = entrada.nextDouble();
                            
                            cliente.ingresar_dinero(indiceCuenta, cantidad);
                            System.out.print("\nIngreso realizado correctamente");
                            System.out.print("Saldo disponible: " + cliente.consultar_saldo(indiceCuenta));
                        }
                        break;
             case 2: System.out.print("Digite el numero de cuenta: ");
                        numeroCuenta = entrada.nextInt();
                        indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);
                        
                        if(indiceCuenta == -1){
                            System.out.print("\nNumero de cuenta erroneo");
                        }
                        else{
                            System.out.print("\nDigite la cantidad de dinero a retirar:");
                            cantidad = entrada.nextDouble();
                            
                            if(cantidad>cliente.consultar_saldo(indiceCuenta)){
                                System.out.print("\nSaldo insuficiente");
                            }
                            else{
                                cliente.retirar_dinero(indiceCuenta, cantidad);
                                System.out.print("\nRetiro realizado correctamente");
                                System.out.print("Saldo disponible: " + cliente.consultar_saldo(indiceCuenta));
                            }        
                        }
                        break;
             case 3: System.out.print("Digite el numero de cuenta: ");
                        numeroCuenta = entrada.nextInt();
                        indiceCuenta = buscarNumeroCuenta(cuentas, numeroCuenta);
                        
                        if(indiceCuenta == -1){
                            System.out.print("\nNumero de cuenta erroneo");
                        }
                        else{
                            System.out.print("Saldo disponible: " + cliente.consultar_saldo(indiceCuenta));
                        }
                        break;
             case 4: break;
             default: System.out.println("Error de opcion");
         }
         System.out.println("");
     }while(opcion != 4);
    }
}
