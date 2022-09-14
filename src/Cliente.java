/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Miguel
 */
public class Cliente {
    
    private String nombre;
    private String apellido;
    private String dni;
    Cuenta cuenta[];

    public Cliente(String nombre, String apellido, String dni, Cuenta[] cuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }
    
    public double consultar_saldo(int n){
        return cuenta[n].getSaldo();
    }
    
    public void ingresar_dinero(int n,double cantidad){
        cuenta[n].ingresarDinero(cantidad);
    }
    
    public void retirar_dinero(int n,double cantidad){
        cuenta[n].retirarDinero(cantidad);
    }
    
}
