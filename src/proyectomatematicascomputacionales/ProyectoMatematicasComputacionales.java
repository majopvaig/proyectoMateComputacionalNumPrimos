/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectomatematicascomputacionales;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Mike
 */
public class ProyectoMatematicasComputacionales {

    /**
     * @param args the command line arguments
     */
    // el programa tiene que hacer:
    // calcular si un numero es primo o compuesto y por que
    // su raiz entera
    // puede mostrar el residuo 
    // sus factores primos
    // podria ser los numeros primos anteriores al numero ingresado
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola tonotos");
        
        // idea de como seria el algoritmo
        List<Integer> divisible = new LinkedList<>();
        int contador = 1;
        int numPrimo = 15;
        if(numPrimo > 9999){
            System.out.println("Numero muy grande, no se puede procesar su calculo.");
        }
        while(contador <= numPrimo){
            if(numPrimo%contador == 0){
                if(contador != numPrimo || contador != 1){
                    divisible.add(contador);
                }
            }
            contador++;
        }
    }
    
}
